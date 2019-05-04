package myUtils;

public class VersionControl {

    protected boolean isBadVersion(int version) {
        if (version > 3) {
            return true;
        }
        return false;
    }

}

