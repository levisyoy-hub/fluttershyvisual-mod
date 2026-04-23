package ru.fluttershy.visual.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleManager {
    private static final ModuleManager INSTANCE = new ModuleManager();
    private final List<Module> modules = new ArrayList<>();
    private final Map<String, Module> modulesByName = new HashMap<>();

    public static ModuleManager getInstance() {
        return INSTANCE;
    }

    public void registerModule(Module module) {
        modules.add(module);
        modulesByName.put(module.getName(), module);
    }

    public Module getModule(String name) {
        return modulesByName.get(name);
    }

    public List<Module> getModules() {
        return new ArrayList<>(modules);
    }

    public List<Module> getModulesByCategory(Category category) {
        return modules.stream().filter(m -> m.getCategory() == category).toList();
    }

    public void updateAll() {
        modules.stream().filter(Module::isEnabled).forEach(Module::onUpdate);
    }

    public void renderAll() {
        modules.stream().filter(Module::isEnabled).forEach(Module::onRender);
    }
}
