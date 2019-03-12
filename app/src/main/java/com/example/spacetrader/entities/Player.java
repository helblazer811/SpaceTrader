package com.example.spacetrader.entities;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;

import com.example.spacetrader.BR;
import com.example.spacetrader.R;
import com.example.spacetrader.entities.planet.Planet;
import com.example.spacetrader.entities.planet.Universe;

import static android.arch.persistence.room.ForeignKey.CASCADE;

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

    private int credits;

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

    //errors
    @Ignore
    public ObservableField<Integer> playerConfigurationError = new ObservableField<>();
    @Ignore
    public ObservableField<Integer> playerNameError = new ObservableField<>();

    @Ignore
    Integer selectedDifficultyPosition = 0;

    public Player(long playerId, String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints, GameDifficulty difficulty, int credits, Inventory inventory, Planet planet, Universe universe) {
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
    }

    @Ignore
    public Player() {
        inventory = new Inventory(10);
        universe = new Universe();
        planet = universe.pickRandomPlanet();
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
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
        this.inventory = inventory;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
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

}
