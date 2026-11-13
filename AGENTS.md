# AGENTS.md

Java 设计模式学习项目（GoF 23 种设计模式），代码位于 `design-patternz/` 目录。

## 代码注释规范

所有代码注释遵循以下规范，便于学习者对照理解。

### 1. 中英文双语

- 注释必须同时包含中文与英文。
- 中文在前，英文在后。

### 2. 类 / 方法级注释（Javadoc）

使用多行 `/** */` 格式，中文一行、英文一行，不使用 HTML 标签（如 `<p>`、`<br>`）：

```java
/**
 * 具体元素：圆形
 * Concrete element: circle
 */
```

### 3. 行内注释（`//`）

使用多行格式（中文一行、英文一行），置于被注释代码的上方，不写在代码行尾：

```java
// 开门：已处于开门状态
// open: already open
elevator.openDoors();
```

### 4. 精简原则

- 注释应简洁，方便理解即可，避免长篇大论。
- 只添加必要的注释，删除无意义的冗余注释。

## 示例实现规范

每个设计模式案例放在独立子包，通过扫描案例根包自动发现，无需注册文件。

### 1. 包结构

- 案例根包：`com.zhuzz.design.patternz`，该包及其子包下的 `DemoCase` 实现会被自动发现。
- 每个案例一个子包：`com.zhuzz.design.patternz.<模式名>/<案例名>/`，例如 `command.lightcontrol`。

### 2. 演示类（`*Demo`）

- 类名以 `Demo` 结尾，实现 `DemoCase` 接口。
- `pattern()` 返回 `I18nMessages` 中对应的 `PAT_*` 常量。
- `caseNames()` 返回中英文显示名映射。
- `run()` 编写演示逻辑，用 `System.out` 输出，由界面捕获展示。

```java
public class LightControlDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_COMMAND; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Light Switch", Locale.SIMPLIFIED_CHINESE, "灯光控制");
    }
    @Override public void run() {
        // 演示逻辑
    }
}
```

### 3. 文件组织

- 一个类型一个文件，模式相关类与演示类放在同一子包。
- 每个案例子包附带 `README.md`（英文）与 `README_zh.md`（中文），统一包含：整体概览、场景描述、设计模式、结构、设计理念。

### 4. 新增模式

- 在 `I18nMessages` 中新增 `PAT_*` 常量并指定所属分类（创建型/结构型/行为型）。
- `PAT_*` 常量按 GoF 经典顺序声明，声明顺序决定界面展示顺序。
- 在 `messages_en.properties`、`messages_zh.properties` 中补充对应翻译。