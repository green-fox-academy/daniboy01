public class BattleApp {

    BattleApp(){

    }
    public static void main(String[] args) {
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();

        ship1.fillShip();
        ship2.fillShip();

        ship1.shipBattle();
        ship2.shipBattle();
    }

}
