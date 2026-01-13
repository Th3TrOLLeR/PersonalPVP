/*
 * Copyright (c) 2022.
 */

package com.nsgwick.personalpvp.config;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;

import java.util.Arrays;
import java.util.List;

import static ch.jalu.configme.properties.PropertyInitializer.newListProperty;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class GeneralConfig implements SettingsHolder {

    /*
    Config.yml settings.
     */
    private static final String PFX_STORAGE = "storage.";
    private static final String PFX_PREVENT = "prevent.";
    private static final String PFX_ACTIONBAR = "toggleable-actionbar.";
    private static final String PFX_CMD_SETTINGS = "command-settings.";
    private static final String PFX_PVP_TOGGLE = "pvp-toggle.";
    private static final String PFX_PVP_CONTROL = "pvp-control.";

    @Comment("The file to store pvp data in.")
    public static final Property<String> FILE =
            newProperty(PFX_STORAGE + "file", "data.ser");


    public static final Property<Boolean> PREVENT_RODS =
            newProperty(PFX_PREVENT + "fishing-rods", true);
    public static final Property<Boolean> PREVENT_PLAYERDAMAGE =
            newProperty(PFX_PREVENT + "damage-from-players", true);
    public static final Property<Boolean> PREVENT_TAMEDDAMAGE =
            newProperty(PFX_PREVENT + "damage-to-or-from-tamed-animals", true);
    public static final Property<Boolean> PREVENT_PROJECTILES =
            newProperty(PFX_PREVENT + "projectiles", true);
    public static final Property<Boolean> PREVENT_POTS =
            newProperty(PFX_PREVENT + "potions", true);
    public static final Property<Boolean> PREVENT_FIRE =
            newProperty(PFX_PREVENT + "combustion-from-players", false);

    public static final Property<Boolean> ABAR_ENABLE =
            newProperty(PFX_ACTIONBAR + "enable", true);
    public static final Property<Boolean> ABAR_DEFAULT_VISIBILITY =
            newProperty(PFX_ACTIONBAR + "default-visibility", true);
    public static final Property<Integer> ABAR_LOGIN_VISIBILITY_DURATION =
            newProperty(PFX_ACTIONBAR + "duration-of-visibility-on-login", 5);
    public static final Property<Integer> ABAR_ATTACK_VISIBILITY_DURATION =
            newProperty(PFX_ACTIONBAR + "duration-of-visibility-on-attack", 5);
    @Comment("Enabling this will wipe current actionbar statuses so make a backup of your data file first!")
    public static final Property<Boolean> ABAR_RESET_ON_Q =
            newProperty(PFX_ACTIONBAR + "reset-actionbar-status-on-quit", true);
    public static final Property<String> ABAR_MESSAGE =
            newProperty(PFX_ACTIONBAR + "message", "<pvpprefix> <gray>-</gray> <gold><worldtime>");
    public static final Property<String>  ABAR_TIME_WORLD =
            newProperty(PFX_ACTIONBAR + "worldtime-in-world", "world");
    public static final Property<String> ABAR_PVP_ENABLED_PFX =
            newProperty(PFX_ACTIONBAR + "pvp-enabled-color-prefix","<gradient:#b82a11:#d41c43>ᴘᴠᴘ: <aqua>ᴇɴᴀʙʟᴇᴅ</aqua></gradient>");
    public static final Property<String> ABAR_PVP_DISABLED_PFX =
            newProperty(PFX_ACTIONBAR + "pvp-disabled-color-prefix","<gradient:#d41c43:#b82a11>ᴘᴠᴘ: <green>ᴅɪsᴀʙʟᴇᴅ</green></gradient>");

    public static final Property<Integer> CMD_PVPTOGGLE_COOLDOWN =
            newProperty(PFX_CMD_SETTINGS + PFX_PVP_TOGGLE + "cooldown", 3);
    public static final Property<Boolean> DEFAULT_PVP_STATUS =
            newProperty(PFX_CMD_SETTINGS + PFX_PVP_TOGGLE + "default-pvp-status-on-first-join", false);
    @Comment("Enabling this will wipe current PVP statuses so make a backup of your data file first!")
    public static final Property<Boolean> RESET_PVP_ON_QUIT =
            newProperty(PFX_CMD_SETTINGS + PFX_PVP_TOGGLE + "reset-pvp-status-on-quit", false);
    public static final Property<Boolean> IS_STATUS_LOCKING =
            newProperty(PFX_CMD_SETTINGS + PFX_PVP_TOGGLE + "locking-enabled", true);
    public static final Property<Boolean> DO_STATUS_LOCKS_RESET_ON_QUIT =
            newProperty(PFX_CMD_SETTINGS + PFX_PVP_TOGGLE + "reset-locks-on-quit", false);
    public static final Property<Boolean> KEEPINV_ON_PVP_DEATH =
            newProperty(PFX_CMD_SETTINGS + PFX_PVP_TOGGLE + "keep-inventory-on-pvpdeath", true);
    public static final Property<Boolean> KEEPXP_ON_PVP_DEATH =
            newProperty(PFX_CMD_SETTINGS + PFX_PVP_TOGGLE + "keep-xp-on-pvpdeath", true);
    public static final Property<Boolean> CMD_PVPTOGGLE_SENDACTIONBAR =
            newProperty(PFX_CMD_SETTINGS + PFX_PVP_TOGGLE + "send-action-bar-on-toggle", true);
    public static final Property<Boolean> CMD_PVPTOGGLE_LOG_EVENTS_TO_CONSOLE =
            newProperty(PFX_CMD_SETTINGS + PFX_PVP_TOGGLE + "log-pvp-toggle-events-to-console", false);
    public static final Property<String> CMD_PVPTOGGLELOG_CONSOLE_FORMAT =
            newProperty(PFX_CMD_SETTINGS + PFX_PVP_TOGGLE + "console-format", "<pvpstatus> ᴘᴠᴘ ғᴏʀ <name>.");
    public static final Property<String> CMD_PVPTOGGLELOG_CONSOLE__PVP_ENABLED_PFX =
            newProperty(PFX_ACTIONBAR + "pvp-enabled-console-prefix","<aqua>ᴇɴᴀʙʟᴇᴅ");
    public static final Property<String> CMD_PVPTOGGLELOG_CONSOLE__PVP_DISABLED_PFX =
            newProperty(PFX_ACTIONBAR + "pvp-disabled-console-prefix","<green>ᴅɪsᴀʙʟᴇᴅ");

    public static final Property<List<String>> CMD_PVPCTRL_PERSONAL_LINES =
            newListProperty(PFX_CMD_SETTINGS + PFX_PVP_CONTROL + "personal-lines", Arrays.asList(
                    "<green>[<click:run_command:/pvp control toggleme><gradient:gray:white><bold>ᴛᴏɢɢʟᴇ ᴘᴠᴘ</bold></gradient></click><green>]",
                    "<green>[<click:run_command:/pvp control mystatus><gradient:white:gray><bold>ɢᴇᴛ ᴘᴠᴘ sᴛᴀᴛᴜs</bold></gradient></click><green>]",
                    "<green>[<click:run_command:/pvp togglebar><gradient:gray:white><bold>ᴛᴏɢɢʟᴇ ᴀᴄᴛɪᴏɴʙᴀʀ ᴠɪsɪʙɪʟɪᴛʏ</bold></gradient></click><green>]"
            ));
    public static final Property<List<String>> CMD_PVPCTRL_LINES =
            newListProperty(PFX_CMD_SETTINGS + PFX_PVP_CONTROL + "lines", List.of(
                    "<green>[<click:suggest_command:/pvp control resetglobal><hover:show_text:'<aqua>ʀᴇsᴇᴛ ᴏғғʟɪɴᴇ ᴘʟᴀʏᴇʀs ᴀs ᴡᴇʟʟ ᴀs ᴏɴʟɪɴᴇ ᴘʟᴀʏᴇʀs.'><gradient:green:aqua><bold>ғᴜʟʟ</bold></gradient> <gradient:aqua:green><bold>ʀᴇsᴇᴛ</bold></gradient></hover></click><green>]"));

    public static final Property<Boolean> ENABLE_PVP_ALERT =
            newProperty("notifications.enable-pvp-alert", true);
}
