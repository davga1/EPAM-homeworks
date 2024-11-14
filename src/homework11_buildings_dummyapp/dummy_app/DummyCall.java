// Պատկերացրեք, որ ունեք տարրական համացանցով զանգ անելու ափփ, որով ուղղակի կարաք զանգեք խոսաք։
// Էկեք իրան անվանենք DummyCall։ Իրանով կարաս զանգ անես, զանգ վերցնես ու զանգն անջատես։
// Մեկ էլ ունի մեթոդ, որով կարաս վերջին զանգի տևողությունը get անես։ Ենթադրենք, որ տվյալ call-ը համարում ենք կայացած,
// երբ DummyCall-ը ստեղծվումա՝ որպես արգումենտ ընդունելով զանգի մասնակիցների ցուցակ, որը 2 հոգուց ավել չի կարա լինի։
// Ամեն մի հոգին դա String-ով նկարագրվող անուն-ազգանունա
package homework11_buildings_dummyapp.dummy_app;

public class DummyCall {
    protected String[] users;
    protected int limit = 2;
    protected int[] calls = new int[0];
    protected boolean callStarted;
    DummyCall(String[] users) {
        setUsers(users);
        makeCall();
        endCall(15);
    }

    DummyCall() {
    }

    public void makeCall() {
        if (!callStarted) {
            setCallStarted(true);
            System.out.println("Started call between:");
            for (String user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("Call is already started");
        }
    }

    public int[] getCalls() {
        return calls;
    }

    public String[] getUsers() {
        return users;
    }

    protected void setUsers(String[] users) {
        if (users.length > limit || users.length < 2) {
            System.out.println("You cannot have more than " + limit + " users");
            System.exit(6);
        }
        this.users = users;
    }

    protected void setCallStarted(boolean callStarted) {
        this.callStarted = callStarted;
    }

    private void extendCallsArray() {
        int[] temp = new int[calls.length + 1];
        for (int i = 0; i < calls.length; i++) {
            temp[i] = calls[i];
        }
        calls = temp;
    }

    protected void endCall(int time) {
        if (callStarted) {
            System.out.println("Call has ended, it lasted " + time + " minutes");
            extendCallsArray();
            calls[calls.length - 1] = time;
            setCallStarted(false);
        } else {
            System.out.println("Call should be started first.");
        }
    }

    public int getLastCallTime() {
        return calls[calls.length - 1];
    }
}