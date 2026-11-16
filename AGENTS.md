# AGENTS.md

Java 设计模式学习项目（GoF 23 种设计模式）。本文件是项目规范与约束的唯一来源，迭代中出现的新规范、新约束统一记录于此。

## 项目概览

- 技术栈：Java 21、Maven；无第三方依赖、无单元测试。
- 代码目录：`design-patternz/`（Maven 项目根）。
- 程序入口：`com.zhuzz.design.lab.LauncherApp`（Swing GUI）。
- 构建方式：Maven Wrapper（`mvnw`）。在 `design-patternz/` 下执行 `.\mvnw.cmd compile`；要求 `JAVA_HOME` 指向 JDK 21。

核心机制：

- 框架代码（`DemoCase`、`DemoRegistry`、`LauncherApp`、`I18n` 等）位于 `com.zhuzz.design.lab` 包。
- 每个设计模式案例是一个实现 `PlaygroundCase` 接口的 `*Demo` 类，放在 `com.zhuzz.design.patternz` 包（或其子包）下。
- `DemoRegistry` 启动时扫描 `patternz` 包，自动发现全部案例，**无需注册**。
- `I18nMessages` 枚举 + `messages_en.properties` / `messages_zh.properties` 提供中英文界面文案。
- 案例运行输出由各子包内的 `output_en.properties` / `output_zh.properties` + `Messages` 提供（见「输出国际化」）。

## 代码注释规范

所有注释必须中英双语，中文在前、英文在后，便于学习者对照理解。

### Javadoc（类 / 方法级）

多行 `/** */` 格式，中文一行、英文一行，禁止 HTML 标签：

```java
/**
 * 具体元素：圆形
 * Concrete element: circle
 */
```

### 行内注释（`//`）

多行格式（中文一行、英文一行），放在被注释代码的**上方**，禁止写在行尾：

```java
// 开门：已处于开门状态
// open: already open
elevator.openDoors();
```

### 精简原则

- 注释简洁，只保留必要注释，删除冗余注释。

## 示例实现规范

### 包结构

- 案例根包：`com.zhuzz.design.patternz`（此包及其子包会被自动扫描）。
- 每个案例一个子包：`com.zhuzz.design.patternz.<模式名>/<案例名>/`，例如 `command.lightcontrol`。

### 演示类（`*Demo`）

- 类名以 `Demo` 结尾，实现 `PlaygroundCase` 接口。
- 类必须 public、非抽象、非接口，有 public 无参构造，且为顶层类（内部类不被扫描）。
- `pattern()` 返回 `I18nMessages` 中的 `PAT_*` 常量。
- `caseNames()` 返回中英文显示名映射。
- `inputs()` 声明可交互的输入项，无参数时返回空列表。
- `run(Map<String, String> values)` 编写演示逻辑，输出统一用 `Messages.println(key, args...)`（由 GUI 捕获展示），文案放入各包的 `output_*.properties`。

```java
public class OfficeSuiteDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_ABSTRACT_FACTORY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Office Suite", Locale.SIMPLIFIED_CHINESE, "办公套件");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "platform",
                Map.of(Locale.ENGLISH, "Platform", Locale.SIMPLIFIED_CHINESE, "平台"),
                PlaygroundInput.Type.CHOICE,
                List.of("Windows", "Linux"),
                "Windows"));
    }
    @Override public void run(Map<String, String> values) {
        String platform = values.getOrDefault("platform", "Windows");
        // 演示逻辑
    }
}
```

### 文件组织

- 一个类型一个文件；模式相关类与演示类放在同一子包。
- 每个案例子包附带 `README.md`（英文）与 `README_zh.md`（中文），统一包含：整体概览、场景描述、设计模式、结构、设计理念。

### 场景设计

- 示例应结合真实世界中常见或好理解的场景（如灯光控制、电梯、文件系统等），便于学习者快速理解模式用途。

## 输出国际化（i18n）

案例运行时打印的文案需支持中英文，规则如下：

- 每个案例子包内放置 `output_en.properties`（英文）与 `output_zh.properties`（中文），与 `README.md` / `README_zh.md` 同级。
- 领域类 / 演示类中的 `System.out.println("...")` 改为 `Messages.println(key, args...)`；只需取文案不打印时用 `Messages.get(key, args...)`。
- `key` 用小写点分命名（如 `tower.clearToLand`），占位符用 `MessageFormat` 的 `{0}` / `{1}`，以支持中英文语序差异。
- 回退链：当前语言 → 英文 → key 本身，漏翻不崩溃、输出仍可读。
- `Messages` 按调用方所在包自动定位同包下的 `output_*.properties`，无需手动传包名。
- `pom.xml` 的 `<resources>` 已配置复制 `src/main/java/**/*.properties`，新增资源无需改动 pom。

```properties
# output_en.properties
tower.clearToLand=Tower: {0} cleared to land.
```

```properties
# output_zh.properties
tower.clearToLand=塔台：{0} 获准降落。
```

```java
Messages.println("tower.clearToLand", plane.getName());
```

## 新增案例 / 模式

在现有模式下新增案例：

1. 新建子包 `com.zhuzz.design.patternz.<模式名>/<案例名>/`。
2. 编写模式相关类（一个类型一个文件）。
3. 编写 `<案例名>Demo` 类，实现 `PlaygroundCase`（满足自动发现约束）。
4. 添加 `README.md` 与 `README_zh.md`。
5. 如案例有运行输出，添加 `output_en.properties` 与 `output_zh.properties`，并用 `Messages.println` 输出（见「输出国际化」）。
6. 在 `design-patternz/` 下执行 `.\mvnw.cmd compile` 验证。

新增全新模式（额外步骤）：

1. 在 `I18nMessages` 中新增 `PAT_*` 常量并指定分类（创建型/结构型/行为型），按 GoF 经典顺序声明（声明顺序决定界面展示顺序）。
2. 在 `messages_en.properties`、`messages_zh.properties` 补充对应翻译。