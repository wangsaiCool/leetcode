package barrierTest;

import java.util.Arrays;

/**
 * Created by WangSai on 2023/6/1
 */
public class BarrierSetting {
    private boolean barrierEnable;
    private long barrierRate;
    private short[] barrierLevel;
    private long[] testUserId;
    private int retryAfterInSeconds;

    //不会被限流URI
    private String[] ignoreURIs;

    public boolean isBarrierEnable() {
        return barrierEnable;
    }

    public BarrierSetting setBarrierEnable(boolean barrierEnable) {
        this.barrierEnable = barrierEnable;
        return this;
    }

    public float getBarrierRate() {
        return barrierRate;
    }

    public BarrierSetting setBarrierRate(long barrierRate) {
        this.barrierRate = barrierRate;
        return this;
    }

    public short[] getBarrierLevel() {
        return barrierLevel;
    }

    public BarrierSetting setBarrierLevel(short[] barrierLevel) {
        this.barrierLevel = barrierLevel;
        return this;
    }

    public long[] getTestUserId() {
        return testUserId;
    }

    public BarrierSetting setTestUserId(long[] testUserId) {
        this.testUserId = testUserId;
        return this;
    }

    public int getRetryAfterInSeconds() {
        return retryAfterInSeconds;
    }

    public BarrierSetting setRetryAfterInSeconds(int retryAfterInSeconds) {
        this.retryAfterInSeconds = retryAfterInSeconds;
        return this;
    }

    public String[] getIgnoreURIs() {
        return ignoreURIs;
    }

    public BarrierSetting setIgnoreURIs(String[] ignoreURIs) {
        this.ignoreURIs = ignoreURIs;
        return this;
    }

    @Override
    public String toString() {
        return "BarrierSetting{" +
                "barrierEnable=" + barrierEnable +
                ", barrierRate=" + barrierRate +
                ", barrierLevel=" + Arrays.toString(barrierLevel) +
                ", testUserId=" + Arrays.toString(testUserId) +
                ", retryAfterInSeconds=" + retryAfterInSeconds +
                ", ignoreURIs=" + Arrays.toString(ignoreURIs) +
                '}';
    }
}
