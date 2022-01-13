package io.github.sjouwer.gammautils.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Tooltip;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;

@Config(name = "gamma_utils")
public class ModConfig implements ConfigData {
    static class AdvancedOptionsObj {
        @Tooltip
        private boolean limitCheck = true;
        @Tooltip
        private int minGamma = -750;
        @Tooltip
        private int maxGamma = 1500;
        @Tooltip
        private boolean showMessage = true;
        @Tooltip
        private boolean saveOptions = true;
    }

    @Tooltip
    private int defaultGamma = 100;
    @Tooltip
    private int toggledGamma = 1500;
    @Tooltip
    private int gammaStep = 10;
    @Tooltip
    private boolean updateToggle = false;
    @CollapsibleObject
    private AdvancedOptionsObj advancedOptions = new AdvancedOptionsObj();

    public double getDefaultGamma() {
        return defaultGamma / 100.0;
    }

    public double getToggledGamma() {
        return toggledGamma / 100.0;
    }

    public void setToggledGamma(double gamma) {
        toggledGamma = (int)Math.round(gamma * 100) ;
    }

    public double getGammaStep() {
        return gammaStep / 100.0;
    }

    public boolean updateToggleEnabled() {
        return updateToggle;
    }

    public boolean limitCheckEnabled() {
        return advancedOptions.limitCheck;
    }

    public double getMinGamma() {
        return advancedOptions.minGamma / 100.0;
    }

    public double getMaxGamma() {
        return advancedOptions.maxGamma / 100.0;
    }

    public boolean gammaMessageEnabled() {
        return advancedOptions.showMessage;
    }

    public boolean optionsSaveEnabled() {
        return advancedOptions.saveOptions;
    }
}