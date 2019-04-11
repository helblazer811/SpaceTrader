package com.example.spacetrader.entities.tradegoods;

 public enum TradeGood {

    WATER(0,0,0,2,30,3.0,4.0,IncreaseEvent.DROUGHT, DecreaseEvent.LOTSOFWATER, ExpensiveEvent.DESERT, 30, 50),
    FURS(1,0,0,0,250,10.0,10.0,IncreaseEvent.COLD, DecreaseEvent.RICHFAUNA,ExpensiveEvent.LIFELESS, 230, 280),
    FOOD(2,1,0,1,100,5.0,5.0,IncreaseEvent.CROPFAIL, DecreaseEvent.RICHSOIL, ExpensiveEvent.POORSOIL, 90, 160),
    ORE(3,2,2,3,350,20.0,10.0, IncreaseEvent.WAR, DecreaseEvent.MINERALRICH, ExpensiveEvent.MINERALPOOR, 350,420),
    GAMES(4,3,1,6,250,-10.0,5.0,IncreaseEvent.BOREDOM, DecreaseEvent.ARTISTIC,null,160,270),
    FIREARMS(5,3,1,5,1250,-75.0,100.0,IncreaseEvent.WAR, DecreaseEvent.WARLIKE, null,600,1100 ),
    MEDICINE(6,4,1,6,650,-20.0,10.0,IncreaseEvent.PLAGUE, DecreaseEvent.LOTSOFHERBS, null, 400, 700),
    MACHINES(7,4,3,5,900,-30.0,5.0,IncreaseEvent.LACKOFWORKERS, null, null, 600, 800),
    NARCOTICS(8,5,0,5,3500,-125.0,150.0,IncreaseEvent.BOREDOM, DecreaseEvent.WEIRDMUSHROOMS, null, 2000, 3000),
    ROBOTS(9,6,4,7,5000,-150.0,100.0,IncreaseEvent.LACKOFWORKERS,null,null,3500,5000);

    public Integer code;
    public Integer minTechLevelProduce;
    public Integer minTechLevelUse;
    public Integer techLevelMost;
    public Integer increasePerTechLevel;
    public Double basePrice;
    public Double variance;
    public IncreaseEvent ie;
    public DecreaseEvent de;
    public ExpensiveEvent ee;
    public Integer minPriceTrader;
    public Integer maxPriceTrader;

    TradeGood(Integer code, Integer minTechLevelProduce, Integer minTechLevelUse, Integer techLevelMost, Integer increasePerTechLevel, Double basePrice, Double variance, IncreaseEvent ie, DecreaseEvent de, ExpensiveEvent ee, Integer minPriceTrader, Integer maxPriceTrader) {
        this.code = code;
        this.minTechLevelProduce = minTechLevelProduce;
        this.minTechLevelUse = minTechLevelUse;
        this.techLevelMost = techLevelMost;
        this.increasePerTechLevel = increasePerTechLevel;
        this.basePrice = basePrice;
        this.variance = variance;
        this.ie = ie;
        this.de = de;
        this.ee = ee;
        this.minPriceTrader = minPriceTrader;
        this.maxPriceTrader = maxPriceTrader;
    }

     /**
      * getter for min TechLevel Produce
      * @return minTechLevelProduce
      */
     public Integer getMinTechLevelProduce() {
         return minTechLevelProduce;
     }
     /**
      * getter for minTechLevelUse
      * @return minTechLevelUse
      */
     public Integer getMinTechLevelUse() {
         return minTechLevelUse;
     }
     /**
      * getter for techLevelMost
      * @return techLevelMost
      */
     public Integer getTechLevelMost() {
         return techLevelMost;
     }
     /**
      * getter for increasePerTechLevel
      * @return increasePerTechLevel
      */
     public Integer getincreasePerTechLevel() {
         return increasePerTechLevel;
     }
     /**
      * getter for basePrice
      * @return basePrice
      */
     public Double getBasePrice() {
         return basePrice;
     }
     /**
      * getter for variance
      * @return variance
      */
     public Double getVariance() {
         return variance;
     }
     /**
      * getter for ie
      * @return ie
      */
     public IncreaseEvent getIe() {
         return ie;
     }
     /**
      * getter for de
      * @return de
      */
     public DecreaseEvent getDe() {
         return de;
     }
     /**
      * getter for ee
      * @return ee
      */
     public ExpensiveEvent getEe() {
         return ee;
     }
     /**
      * getter for minPriceTrader
      * @return mindOriceTrader
      */
     public Integer getMinPriceTrader() {
         return minPriceTrader;
     }
     /**
      * getter for getMaxPriceTrader
      * @return getMaxPriceTrader
      */
     public Integer getMaxPriceTrader() {
         return maxPriceTrader;
     }

     /**
      * setter for code
      * @param code being set
      */
     public void setCode(Integer code) {
         this.code = code;
     }

     /**
      * setter for minTechLevelProduce
      * @param minTechLevelProduce being set
      */
     public void setMinTechLevelProduce(Integer minTechLevelProduce) {
         this.minTechLevelProduce = minTechLevelProduce;
     }

     /**
      * setter for minTechLevelUse
      * @param minTechLevelUse being set
      */
     public void setMinTechLevelUse(Integer minTechLevelUse) {
         this.minTechLevelUse = minTechLevelUse;
     }

     /**
      * setter for techLevelMost
      * @param techLevelMost being set
      */
     public void setTechLevelMost(Integer techLevelMost) {
         this.techLevelMost = techLevelMost;
     }

     /**
      * setter for increasePerTechLevel
      * @param increasePerTechLevel being set
      */
     public void setincreasePerTechLevel(Integer increasePerTechLevel) {
         this.increasePerTechLevel = increasePerTechLevel;
     }

     /**
      * setter for basePrice
      * @param basePrice being set
      */
     public void setBasePrice(Double basePrice) {
         this.basePrice = basePrice;
     }

     /**
      * setter for variance
      * @param variance being set
      */
     public void setVariance(Double variance) {
         this.variance = variance;
     }

     /**
      * setter for ie
      * @param ie being set
      */
     public void setIe(IncreaseEvent ie) {
         this.ie = ie;
     }

     /**
      * setter for de
      * @param de being set
      */
     public void setDe(DecreaseEvent de) {
         this.de = de;
     }

     /**
      * setter for ee
      * @param ee ee being set
      */
     public void setEe(ExpensiveEvent ee) {
         this.ee = ee;
     }

     /**
      * setter for minPriceTrader
      * @param minPriceTrader being set
      */
     public void setMinPriceTrader(Integer minPriceTrader) {
         this.minPriceTrader = minPriceTrader;
     }

     /**
      * setter for maxPriceTrader
      * @param maxPriceTrader being set
      */
     public void setMaxPriceTrader(Integer maxPriceTrader) {
         this.maxPriceTrader = maxPriceTrader;
     }

     /**
      * getter for code
      * @return code of object
      */
     public Integer getCode() {
        return code;
    }
}
