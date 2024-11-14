//Ու վերջապես ունենք համ էլ DummyAppProMax տարբերակը, որով կարում ենք դաժԸ էկրան share անենք։
// Էկրան շեյր անելը կարող ենք միայն քոլի առկայության դեպքում, այսինքն հենց սկզբից չենք կարա share անենք։
// Էկրանը շեյրա արած թե չէ, էդ ինֆոն դուք մտածեք ոնց պահեք, բայց մեթոդ պետքա ունենա Ձեր DummyAppProMax կլասը,
// որով անջատում միացնում եք sharing-ը։
package homework11_buildings_dummyapp.dummy_app;

public class DummyAppProMax extends DummyAppPro{
    private boolean isScreenShared;
    DummyAppProMax(String[] users){
        super();
        super.limit = 10;
        setUsers(users);
        makeCall();
        endCall(25);
    }
    public void shareScreen(){
        if(callStarted){
            setScreenShared(true);
            System.out.println("Screen is shared now");
        } else System.out.println("Cannot share screen without call");
    }

    public boolean isScreenShared() {
        return isScreenShared;
    }

    public void setScreenShared(boolean screenShared) {
        isScreenShared = screenShared;
    }
}
