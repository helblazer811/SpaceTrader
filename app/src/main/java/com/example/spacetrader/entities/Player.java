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
//import androidx.databinding.BaseObservable;
import androidx.databinding.*;
//import androidx.databinding.Bindable;
//import androidx.databinding.InverseBindingMethod;
//import androidx.databinding.InverseBindingMethods;
//import androidx.databinding.ObservableField;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * The player class is the beating heart of this game.
 */
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

    /**
     * Constructor for player
     * @param playerId the unique id
     * @param name player name
     * @param pilotPoints points in pilot skill
     * @param fighterPoints fighter skill
     * @param traderPoints trader skill
     * @param engineerPoints engineer skill
     * @param difficulty the difficulty the player is playing
     * @param credits money
     * @param inventory what the player has
     * @param planet the planet the player is on
     * @param universe the universe the player plays in
     * @param ship the ship the player is flying
     * @param enemy potential enemies the player has
     */
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

    /**
     * alternate constructor; ignore
     */
    @Ignore
    public Player() {
        inventory = new Inventory(10);
        universe = new Universe();
        ship = new Ship(ShipType.FIREFLY);
        planet = universe.pickRandomPlanet();
        credits = 1000;
        enemy = new Enemy();
    }

    /**
     * a getter for the player ID for the database
     * @return the player ID
     */
    public long getPlayerId() {
        return playerId;
    }

    /**
     * a setter for the player ID for the database
     * @param playerId the new player ID to set
     */
    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    /**
     * a getter for the pilot skill level stat
     * @return the pilot skill level
     */
    public int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * a setter for the pilot skill level stat
     * @param pilotPoints the new pilot skill level to set
     */
    public void setPilotPoints(int pilotPoints) {
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
        this.pilotPoints = pilotPoints;
    }

    /**
     * a getter for the fighter skill level stat
     * @return the fighter skill level
     */
    public int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * a setter for the fighter skill level stat
     * @param fighterPoints the new fighter skill level to set
     */
    public void setFighterPoints(int fighterPoints) {
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
        this.fighterPoints = fighterPoints;
    }

    /**
     * a getter for the trader skill level stat
     * @return the trader skill level
     */
    public int getTraderPoints() {
        return traderPoints;
    }

    /**
     * a setter for the trader skill level stat
     * @param traderPoints the new trader skill level to set
     */
    public void setTraderPoints(int traderPoints) {
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
        this.traderPoints = traderPoints;
    }

    /**
     * a getter for the engineer skill level stat
     * @return the engineer skill level
     */
    public int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * a setter for the engineer skill level stat
     * @param engineerPoints the new engineer skill level to set
     */
    public void setEngineerPoints(int engineerPoints) {
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
        this.engineerPoints = engineerPoints;
    }

    /**
     * a getter for the player name
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * a setter for the player name
     * @param name the new player name to set
     */
    public void setName(String name) {
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
        this.name = name;
    }

    /**
     * a getter for the game difficulty
     * @return the game difficulty
     */
    @Bindable
    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    /**
     * a setter for the game difficulty
     * @param difficulty the new game difficulty to set
     */
    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
        //notifyPropertyChanged(BR.);
    }

    /**
     * a getter for the selected difficulty position
     * @return the selected difficulty position
     */
    @Bindable
    public Integer getSelectedDifficultyPosition() {
        return selectedDifficultyPosition;
    }

    /**
     * a setter for the selected difficulty position; also sets the official game difficulty
     * @param position the new game difficulty to set, represented as the selector position
     */
    public void setSelectedDifficultyPosition(Integer position) {
        selectedDifficultyPosition = position;
        difficulty = GameDifficulty.values()[selectedDifficultyPosition];
    }

    /**
     * a getter for the number of credits
     * @return the number of credits
     */
    public double getCredits() {
        return credits;
    }

    /**
     * a setter for the number of credits
     * @param credits the new number of credits to set
     */
    public void setCredits(double credits){
        notifyPropertyChanged(BR.validPurchase);
        this.credits = credits;
    }

    /**
     * a getter for the universe
     * @return the universe
     */
    public Universe getUniverse() {
        return universe;
    }

    /**
     * a setter for the universe
     * @param universe the new universe to set
     */
    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    /**
     * a getter for the inventory
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * a setter for the inventory
     * @param inventory the new inventory to set
     */
    public void setInventory(Inventory inventory) {
        notifyPropertyChanged(BR.validPurchase);
        this.inventory = inventory;
    }

    /**
     * a getter for the planet
     * @return the planet
     */
    public Planet getPlanet() {
        return planet;
    }

    /**
     * a setter for the planet
     * @param planet the new planet to set
     */
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    /**
     * a getter for the ship
     * @return the ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * a setter for the ship
     * @param ship the new ship to set
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * calls a valid stat config checker method without generating an error
     * @return true if the stat config is valid, false otherwise
     */
    @Bindable
    public boolean isValid() {
        return isValidConfiguration(false);
    }

    /**
     * checks if the current stat config is valid (i.e. 16 points allocated)
     * @param setMessage determines if errors should be generated for invalid configs
     * @return true if the stat config is valid, false otherwise
     */
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

    /**
     * modifies the amount of credits a player has
     * @param amount the amount of credits that are being added/removed from a player
     */
    public void changeCredits(Double amount) {
        credits += amount;
    }

    /**
     * generates a String representation of the player
     * @return a String representation of the player
     */
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

    /**
     * determines the remaining space in the player's inventory
     * @return the number of available spaces in the inventory
     */
    public int getAvailableInventorySpace() {
        return inventory.getCapacity() - inventory.getCount();
    }

    /**
     * executes all aspects of a purchase by adding items to player inventory, charging credits, and
     * modifying the source planet's inventory
     * @param purchase the purchase to use to perform calculations
     */
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

    /**
     * executes all aspects of a sale by removing items from player inventory, charging credits, and
     * modifying the source planet's inventory
     * @param sale the purchase to use to perform calculations
     */
    public void applySale(Sale sale) {
        inventory.applySale(sale);
        credits += sale.getSaleAmount();
        for (TradeGood good: planet.getPlanetInventory().keySet()) {
            planet.getPlanetInventory().put(good,
                    planet.getPlanetInventory().get(good)
                            + sale.getSaleAmounts().get(good));
        }
    }

    /**
     * checks if a given planet can be reached given its distance to another planet vs. fuel
     * reserves
     * @param planet the planet to reach
     * @return true if the planet can be reached and false otherwise
     */
    public boolean isPlanetWithinRange(Planet planet) {
        //fuel is in the units of distance
        return calculateDistance(planet, this.planet) < ship.getFuel();
    }

    /**
     * move the player to a new planet and generate an event
     * @param planet the planet to travel to
     * @return the random event the player encounters
     */
    public RandomEvent travelToPlanet(Planet planet) {
        //subtracts fuel
        ship.setFuel(ship.getFuel() - calculateDistance(this.planet, planet));
        //change player location
        this.planet = planet;

        //return a random event

        return EventLoader.loadRandomEvent(this);
    }

    /**
     * determines the distance between two planets
     * @param a the first planet
     * @param b the second planet
     * @return the distance, rounded up, between two planets
     */
    private int calculateDistance(Planet a, Planet b) {
        //simple pythagorean theorem
        return (int) Math.ceil(
                    Math.sqrt(
                        Math.pow(a.getXLoc() - b.getXLoc(), 2)
                        + Math.pow(a.getYLoc() - b.getYLoc(), 2)
                        )
                );

    }

    /**
     * determines the distance between the planet the player is on and a given planet
     * @param planet the planet to compare to
     * @return the distance between the planets
     */
    public int getDistance(Planet planet) {
        return calculateDistance(planet, this.planet);
    }

    /**
     * determines planets that are within traveling range
     * @return a List of planets that can be reached from the player's location
     */
    public List<Planet> getPlanetsWithinRange() {
        List<Planet> list = new ArrayList<>();

        for (Planet planet: universe.getPlanets()) {
            if (isPlanetWithinRange(planet)) {
                list.add(planet);
            }
        }

        return list;
    }

    /**
     * checks if the ship has not been destroyed
     * @return true if the ship is alive, false otherwise
     */
    public boolean isAlive() {
        return ship.isAlive();
    }

    /**
     * clears the player's inventory
     */
    public void emptyInventory() {
        inventory.emptyInventory();
    }

    /**
     * halves the health of the player's ship
     */
    public void setPlayerHealthHalf() {
        ship.setHealthHalf();
    }

    /**
     * a getter for the player's current enemy
     * @return the current enemy
     */
    public Enemy getEnemy() {
        return enemy;
    }

    /**
     * a setter for the player's current enemy
     * @param enemy the new enemy to set
     */
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    /**
     * deals damage to the player's ship
     * @param damage the amount of damage to do
     */
    public void doDamage(int damage) {
        this.getShip().takeDamage(damage);
    }
}
