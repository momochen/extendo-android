package net.fortytwo.extendo.ping;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author Joshua Shinavier (http://fortytwo.net)
 */
public abstract class Pinger {
    private static final float DEFAULT_FREQUENCY = 1.0f;

    private final String name;
    private final float frequency;

    public Pinger(final String name,
                  final Context context) {
        this.name = name;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        frequency = prefs.getFloat(name + "_ping_freq", DEFAULT_FREQUENCY);
    }

    public abstract Ping createPing();

    /**
     * @return a globally unique identifier for this pinger
     */
    public String getName() {
        return name;
    }

    /**
     * @return average frequency (pings per day)
     */
    public float getFrequency() {
        return frequency;
    }
}
