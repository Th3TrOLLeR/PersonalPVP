/*
 * Copyright (c) 2025.
 */

package com.nsgwick.personalpvp;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

/**
 * PlaceholderAPI expansion for PersonalPVP
 * Provides placeholders to check if a player has PVP enabled/disabled
 */
public class PersonalPVPExpansion extends PlaceholderExpansion {

    private final PPVPPlugin plugin;

    public PersonalPVPExpansion(PPVPPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    @NotNull
    public String getIdentifier() {
        return "personalpvp";
    }

    @Override
    @NotNull
    public String getAuthor() {
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    @NotNull
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true; // This is required or else PlaceholderAPI will unregister the Expansion on reload
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        if (player == null) {
            return "";
        }

        // %personalpvp_enabled%
        if (params.equalsIgnoreCase("enabled")) {
            return plugin.pvp().pvpPositive(player.getUniqueId()) ? "true" : "false";
        }

        // %personalpvp_disabled%
        if (params.equalsIgnoreCase("disabled")) {
            return plugin.pvp().pvpNegative(player.getUniqueId()) ? "true" : "false";
        }

        // %personalpvp_status%
        if (params.equalsIgnoreCase("status")) {
            return plugin.pvp().pvpPositive(player.getUniqueId()) ? "enabled" : "disabled";
        }

        // %personalpvp_status_colored%
        if (params.equalsIgnoreCase("status_colored")) {
            return plugin.pvp().pvpPositive(player.getUniqueId()) ? "§aᴇɴᴀʙʟᴇᴅ" : "§cᴅɪsᴀʙʟᴇᴅ";
        }

        // %personalpvp_locked%
        if (params.equalsIgnoreCase("locked")) {
            return plugin.pvp().isLocked(player.getUniqueId()) ? "true" : "false";
        }

        // %personalpvp_lock_status%
        if (params.equalsIgnoreCase("lock_status")) {
            return plugin.pvp().isLocked(player.getUniqueId()) ? "locked" : "unlocked";
        }

        return null; // Placeholder is unknown by the Expansion
    }
}

