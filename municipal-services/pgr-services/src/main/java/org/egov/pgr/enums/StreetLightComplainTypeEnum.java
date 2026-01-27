package org.egov.pgr.enums;

import lombok.Getter;

@Getter
public enum StreetLightComplainTypeEnum {

    LIGHT_BLINKING(1, "Light Blinking"),
    LED_OFF(2, "LED OFF"),
    POLE_DAMAGE(3, "Pole Damage"),
    ARM_BRACKET_DAMAGE(4, "Arm/Bracket Damage"),
    JUNCTION_BOX_DAMAGE_OPEN(5, "Junction Box Damage/Open"),
    SHOCK_ON_POLE(6, "Shock On Pole"),
    CABLE_HANGING_BREAK(7, "Cable hanging or break"),
    CABLE_LAYING_JOINTS_OPEN(8, "Cable laying Open or Open Joints"),
    FEEDER_PANEL_OFF(9, "Feeder Panel OFF"),
    FEEDER_DAMAGED(10, "Feeder Damaged"),
    SHOCK_ON_FEEDER_PANEL(11, "Shock on Feeder Panel"),
    NEW_LED_INSTALLATION(12, "New LED Installation"),
    NEW_POLE_INSTALLATION(13, "New Pole Installation"),
    POLE_SHIFTING_REQUIRED(14, "Pole Shifting Required"),
    OTHERS(15, "Others");

    private final int id;
    private final String name;

    StreetLightComplainTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
