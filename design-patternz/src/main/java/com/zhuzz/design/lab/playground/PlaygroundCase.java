package com.zhuzz.design.lab.playground;

import com.zhuzz.design.lab.DemoCase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 可参数化沙盒案例：在 DemoCase 基础上声明一组输入项，并按用户选定的值运行。
 * 现有普通 DemoCase 不受影响；新增案例改为实现本接口即可获得参数化交互能力。
 * A parameterized playground case: declares inputs and runs with user-provided values.
 * Existing plain DemoCases are unaffected; new cases implement this to gain interactivity.
 */
public interface PlaygroundCase extends DemoCase {

    /** 声明该案例暴露的输入项。Declare the inputs exposed by this case. */
    List<PlaygroundInput> inputs();

    /** 按用户选定的参数值运行。Run with the user-provided values. */
    void run(Map<String, String> values);

    /** 无参 run() 降级为按默认值运行，保持与 DemoCase 兼容。Default run() uses default values. */
    @Override
    default void run() {
        run(defaultValues());
    }

    /** 汇总所有输入项的默认值。Collect the default value of every input. */
    default Map<String, String> defaultValues() {
        Map<String, String> defaults = new LinkedHashMap<>();
        for (PlaygroundInput input : inputs()) {
            defaults.put(input.id(), input.defaultValue());
        }
        return defaults;
    }
}