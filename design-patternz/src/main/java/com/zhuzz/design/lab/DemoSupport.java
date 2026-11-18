package com.zhuzz.design.lab;

import com.zhuzz.design.lab.i18n.I18n;
import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 可独立运行的案例基类：实现 {@link PlaygroundCase}，并提供继承的 {@code static main}，
 * 使每个子类 Demo 可直接作为独立程序运行（{@code java <DemoClass>}），无需启动 GUI。
 * <p>
 * 子类只需把原本的 {@code implements PlaygroundCase} 改为 {@code extends DemoSupport}，
 * 其余方法（{@code pattern()} / {@code caseNames()} / {@code inputs()} / {@code run(Map)}）无需改动。
 * <p>
 * Standalone-runnable case base: implements {@link PlaygroundCase} and provides an inherited
 * {@code static main}, so each subclass Demo can be run directly as a standalone program
 * ({@code java <DemoClass>}) without launching the GUI.
 * <p>
 * Subclasses only need to change {@code implements PlaygroundCase} to {@code extends DemoSupport};
 * all other methods ({@code pattern()} / {@code caseNames()} / {@code inputs()} / {@code run(Map)}) stay unchanged.
 */
public abstract class DemoSupport implements PlaygroundCase {

    /**
     * 独立运行入口：通过 {@code sun.java.command} 反查真正被启动的子类，实例化后按命令行参数运行。
     * 用法：{@code java <DemoClass> [--key=value ...] [--lang en|zh] [--help]}
     * <p>
     * Standalone entry point: resolves the actually-launched subclass via {@code sun.java.command},
     * instantiates it, and runs it with the supplied command-line arguments.
     * Usage: {@code java <DemoClass> [--key=value ...] [--lang en|zh] [--help]}
     */
    public static void main(String[] args) throws Exception {
        Class<?> launched = resolveLaunchedClass();
        DemoSupport demo = (DemoSupport) launched.getDeclaredConstructor().newInstance();
        runWithArgs(demo, args);
    }

    /**
     * 反查被 {@code java <类名>} 直接启动的类全名。
     * 优先使用 HotSpot 的 {@code sun.java.command} 属性，回退到 {@link ProcessHandle} 命令行。
     * Resolves the FQCN of the class launched directly via {@code java <classname>}.
     * Prefers the HotSpot {@code sun.java.command} property, falling back to {@link ProcessHandle}.
     */
    static Class<?> resolveLaunchedClass() throws ClassNotFoundException {
        String cmd = System.getProperty("sun.java.command");
        if (cmd == null || cmd.isBlank()) {
            cmd = ProcessHandle.current().info().commandLine().orElse("");
        }
        if (cmd.isBlank()) {
            throw new IllegalStateException(
                    "无法确定启动类（sun.java.command 为空）/ Cannot resolve launch class");
        }
        String first = cmd.split("\\s+")[0];
        // 仅支持直接 java <类名> 启动；-jar 与裸 java 命令无明确的 Demo 类
        // Only direct class launch is supported; -jar and bare java commands have no clear Demo class
        if (first.endsWith(".jar") || first.equals("java") || first.equals("javaw")) {
            throw new IllegalStateException(
                    "DemoSupport.main 仅支持直接 java <类名> 启动 / Only direct class launch is supported");
        }
        return Class.forName(first);
    }

    /**
     * 解析参数并运行案例。{@code --help/-h} 打印帮助后退出；
     * {@code --lang <tag>} 切换输出语言；其余 {@code --key=value} 或 {@code --key value} 写入参数映射。
     * Parses arguments and runs the case. {@code --help/-h} prints help and exits;
     * {@code --lang <tag>} switches the output language; other {@code --key=value} or
     * {@code --key value} pairs are written into the value map.
     */
    static void runWithArgs(DemoSupport demo, String[] args) {
        Map<String, String> values = new LinkedHashMap<>(demo.defaultValues());
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if ("--help".equals(arg) || "-h".equals(arg)) {
                printHelp(demo);
                return;
            }
            if (arg.startsWith("--lang=")) {
                applyLang(arg.substring("--lang=".length()));
                continue;
            }
            if ("--lang".equals(arg)) {
                if (i + 1 >= args.length) {
                    System.err.println("--lang 缺少参数 / Missing value for --lang");
                    System.exit(2);
                }
                applyLang(args[++i]);
                continue;
            }
            if (arg.startsWith("--")) {
                String key;
                String val;
                int eq = arg.indexOf('=');
                if (eq >= 0) {
                    key = arg.substring(2, eq);
                    val = arg.substring(eq + 1);
                } else {
                    key = arg.substring(2);
                    if (i + 1 >= args.length) {
                        System.err.println("--" + key + " 缺少参数 / Missing value for --" + key);
                        System.exit(2);
                    }
                    val = args[++i];
                }
                values.put(key, val);
            }
        }
        validateChoices(demo, values);
        demo.run(values);
    }

    private static void applyLang(String lang) {
        I18n.switchTo(Locale.forLanguageTag(lang));
    }

    /**
     * 校验 CHOICE 类型输入值是否在可选项内，非法时打印错误并以状态码 2 退出。
     * Validates CHOICE input values against their available choices; prints an error
     * and exits with code 2 on an illegal value.
     */
    private static void validateChoices(DemoSupport demo, Map<String, String> values) {
        for (PlaygroundInput input : demo.inputs()) {
            if (input.type() != PlaygroundInput.Type.CHOICE) continue;
            String val = values.get(input.id());
            if (val == null) continue;
            if (!input.choices().contains(val)) {
                System.err.println("非法值 Invalid value for '" + input.id() + "': " + val
                        + "；可选 valid: " + input.choices());
                System.exit(2);
            }
        }
    }

    private static void printHelp(DemoSupport demo) {
        Locale locale = I18n.getCurrentLocale();
        System.out.println("Usage / 用法: java " + demo.getClass().getName() + " [options]");
        System.out.println("Options / 选项:");
        System.out.println("  --help, -h          显示帮助 / Show this help");
        System.out.println("  --lang <tag>        设置输出语言（如 en、zh）/ Set output language (e.g. en, zh)");
        for (PlaygroundInput input : demo.inputs()) {
            StringBuilder sb = new StringBuilder("  --").append(input.id());
            if (input.type() == PlaygroundInput.Type.CHOICE) {
                sb.append(" <").append(String.join("|", input.choices())).append(">");
            } else {
                sb.append(" <value>");
            }
            sb.append("    默认 default: ").append(input.defaultValue());
            String label = input.label(locale);
            if (!label.equals(input.id())) {
                sb.append("    （").append(label).append("）");
            }
            System.out.println(sb);
        }
    }
}