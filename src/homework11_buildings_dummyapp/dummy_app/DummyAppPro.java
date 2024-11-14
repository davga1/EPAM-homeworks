//Սրա հետ զուգահեռ ունեք նաև DummyApp-ի զարգացրած տեսակը՝ DummyAppPro-ն, որով կարողանում եք համ videocall անել,
// համ էլ մինչև 10 հոգի մասնակից ընդգրկել քոլի մեջ։ Կրկին call-ը դառնումա կայացած, եթե DummyAppPro օբյեկտը սարքվումա։
// Ընդ որում, երբ ասում եմ հնարավորություն կա վիդեոքոլ անելու, չի նշանակում, որ էս հենց պիտի վիդեոքոլ անես,
// բայց ձև պետքա լինի հենց սկզբից, կամ ընթացքում միացնելու։ Camera-ն կարա լինի կամ անջատած, կամ միացրած։
// Նենց որ դուք որոշեք ինչ տիպով ու ոնց եք պահում կամեռայի անջատած/միացրած լինելու ինֆոն։
// Մի հատ էլ ինֆո. երբ քոլը վերջանումա, տվյալ օբյեկտը պետքա ենթակա դարձնեք ոչնչացման։
// Թե ոնց անեք, էդ էլ դուք գիտեք։

package homework11_buildings_dummyapp.dummy_app;

public class DummyAppPro extends DummyCall {
    private boolean cameraIsOn;

    DummyAppPro(){}

    DummyAppPro(String[] users) {
        super();
        super.limit = 10;
        setUsers(users);
        makeCall();
        endCall(25);
    }

    public void toggleCamera() {
        cameraIsOn = !cameraIsOn;
        System.out.println("Camera is " + (cameraIsOn ? "on, so now the call is a videocall" : "off"));
    }
}
