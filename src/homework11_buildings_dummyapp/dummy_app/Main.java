package homework11_buildings_dummyapp.dummy_app;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String a = "David Galstyan";
        String b = "Andranik Galstyan";
        DummyCall c = new DummyCall(new String[]{a, b});
        c.makeCall();
        c.endCall(25);
        c.makeCall();
        c.endCall(15);
        c.makeCall();
        c.endCall(45);
        System.out.println(c.getLastCallTime());
        System.out.println("-------------------------------");
        DummyAppPro d = new DummyAppPro(new String[]{a,b,a,b,a,b});
        System.out.println(Arrays.toString(d.getCalls()));
        d.toggleCamera();
        d.makeCall();
        d.endCall(13);
        System.out.println(d.getLastCallTime());
        System.out.println("-------------------------------");
        DummyAppProMax e = new DummyAppProMax(new String[]{a,b,a,b});
        e.shareScreen();
        e.makeCall();
        e.endCall(47);
        e.shareScreen();
        e.makeCall();
        e.shareScreen();
        e.endCall(49);
        e.getLastCallTime();
    }
}
