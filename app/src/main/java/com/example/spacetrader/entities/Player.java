package com.example.spacetrader.entities;

import com.example.spacetrader.BR;
import com.example.spacetrader.R;
import com.example.spacetrader.entities.event.Enemy;
import com.example.spacetrader.entities.event.EventLoader;
import com.example.spacetrader.entities.event.RandomEvent;
import com.example.spacetrader.entities.planet.Planet;
import com.example.spacetrader.entities.planet.Universe;
import com.example.spacetrader.entities.ship.Ship;
import com.example.spacetrader.entities.ship.ShipType;
import com.example.spacetrader.entities.tradegoods.Purchase;
import com.example.spacetrader.entities.tradegoods.Sale;
import com.example.spacetrader.entities.tradegoods.TradeGood;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;
import androidx.databinding.ObservableField;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
@InverseBindingMethods({
        @InverseBindingMethod(type = AppCompatSpinner.class, attribute = "android:selectedItemPosition"),
})
public class Player extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    private long playerId;

    private String name;

    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;

    private GameDifficulty difficulty;

    private double credits;

    /*
        Encapsulated objects.
        These objects are not stored in the database.
        Instead keys are stored for them and the repository class
        handles building up the object from the disconnected data
        in different tables
    */
    @Embedded
    private Inventory inventory;
    @Embedded
    private Planet planet;
    @Embedded
    private Universe universe;
    @Embedded
    private Ship ship;
    @Embedded
    private Enemy enemy;

    //errors
    @Ignore
    public ObservableField<Integer> playerConfigurationError = new ObservableField<>();
    @Ignore
    public ObservableField<Integer> playerNameError = new ObservableField<>();

    @Ignore
    Integer selectedDifficultyPosition = 0;

    public Player(long playerId, String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints, GameDifficulty difficulty, double credits, Inventory inventory, Planet planet, Universe universe, Ship ship, Enemy enemy) {
        this.playerId = playerId;
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.difficulty = difficulty;
        this.credits = credits;
        this.inventory = inventory;
        this.planet = planet;
        this.universe = universe;
        this.ship = ship;
        this.enemy = enemy;
    }

    @Ignore
    public Player() {
        inventory = new Inventory(10);
        universe = new Universe();
        ship = new Ship(ShipType.FIREFLY);
        planet = universe.pickRandomPlanet();
        credits = 1000;
        enemy = new Enemy();
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public int getPilotPoints() {
        return pilotPoints;
    }

    public void setPilotPoints(int pilotPoints) {
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
        this.pilotPoints = pilotPoints;
    }

    public int getFighterPoints() {
        return fighterPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
        this.fighterPoints = fighterPoints;
    }

    public int getTraderPoints() {
        return traderPoints;
    }

    public void setTraderPoints(int traderPoints) {
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
        this.traderPoints = traderPoints;
    }

    public int getEngineerPoints() {
        return engineerPoints;
    }

    public void setEngineerPoints(int engineerPoints) {
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
        this.engineerPoints = engineerPoints;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
        this.name = name;
    }

    @Bindable
    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
        //notifyPropertyChanged(BR.);
    }

    @Bindable
    public Integer getSelectedDifficultyPosition() {
        return selectedDifficultyPosition;
    }

    public void setSelectedDifficultyPosition(Integer position) {
        selectedDifficultyPosition = position;
        difficulty = GameDifficulty.values()[selectedDifficultyPosition];
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits){
        notifyPropertyChanged(BR.validPurchase);
        this.credits = credits;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        notifyPropertyChanged(BR.validPurchase);
        this.inventory = inventory;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Bindable
    public boolean isValid() {
        return isValidConfiguration(false);
    }

    public boolean isValidConfiguration(boolean setMessage) {
        int sum = 0;
        sum += pilotPoints;
        sum += engineerPoints;
        sum += traderPoints;
        sum += fighterPoints;

        int totalPoints = 16;

        if (sum < totalPoints) {
            if (setMessage) {
                playerConfigurationError.set(R.string.error_player_config_low);
            }
            return false;
        } else if (sum > totalPoints) {
            if (setMessage) {
                playerConfigurationError.set(R.string.error_player_config_high);
            }
            return false;
        } else {
            playerConfigurationError.set(null);
            return true;
        }
    }

    public void changeCredits(Double amount) {
        credits += amount;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pilotPoints=" + pilotPoints +
                ", fighterPoints=" + fighterPoints +
                ", traderPoints=" + traderPoints +
                ", engineerPoints=" + engineerPoints +
                ", difficulty=" + difficulty +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }

    public int getAvailableInventorySpace() {
        return inventory.getCapacity() - inventory.getCount();
    }

    public void applyPurchase(Purchase purchase) {
        inventory.applyPurchase(purchase);
        ship.setFuel(ship.getFuel() + purchase.getFuel());
        credits -= purchase.getPurchaseAmount();
        for (TradeGood good: planet.getPlanetInventory().keySet()) {
            planet.getPlanetInventory().put(good,
                    planet.getPlanetInventory().get(good)
                            - purchase.getAmounts().get(good));
        }
    }

    public void applySale(Sale sale) {
        inventory.applySale(sale);
        credits += sale.getSaleAmount();
        for (TradeGood good: planet.getPlanetInventory().keySet()) {
            planet.getPlanetInventory().put(good,
                    planet.getPlanetInventory().get(good)
                            + sale.getSaleAmounts().get(good));
        }
    }

    public boolean isPlanetWithinRange(Planet planet) {
        //fuel is in the units of distance
        return calculateDistance(planet, this.planet) < ship.getFuel();
    }

    public RandomEvent travelToPlanet(Planet planet) {
        //subtracts fuel
        ship.setFuel(ship.getFuel() - calculateDistance(this.planet, planet));
        //change player location
        this.planet = planet;

        //return a random event

        return EventLoader.loadRandomEvent(this);
    }

    private int calculateDistance(Planet a, Planet b) {
        //simple pythagorean theorem
        return (int) Math.ceil(
                    Math.sqrt(
                        Math.pow(a.getXLoc() - b.getXLoc(), 2)
                        + Math.pow(a.getYLoc() - b.getYLoc(), 2)
                        )
                );

    }

    public int getDistance(Planet planet) {
        return calculateDistance(planet, this.planet);
    }

    public List<Planet> getPlanetsWithinRange() {
        List<Planet> list = new ArrayList<>();

        for (Planet planet: universe.getPlanets()) {
            if (isPlanetWithinRange(planet)) {
                list.add(planet);
            }
        }

        return list;
    }

    public boolean isAlive() {
        return ship.isAlive();
    }

    public void emptyInventory() {
        inventory.emptyInventory();
    }

    public void setPlayerHealthHalf() {
        ship.setHealthHalf();
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
