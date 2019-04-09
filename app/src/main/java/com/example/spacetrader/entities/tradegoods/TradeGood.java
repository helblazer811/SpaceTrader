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
    public Integer increacePerTechLevel;
    public Double basePrice;
    public Double variance;
    public IncreaseEvent ie;
    public DecreaseEvent de;
    public ExpensiveEvent ee;
    public Integer minPriceTrader;
    public Integer maxPriceTrader;

    TradeGood(Integer code, Integer minTechLevelProduce, Integer minTechLevelUse, Integer techLevelMost, Integer increacePerTechLevel, Double basePrice, Double variance, IncreaseEvent ie, DecreaseEvent de, ExpensiveEvent ee, Integer minPriceTrader, Integer maxPriceTrader) {
        this.code = code;
        this.minTechLevelProduce = minTechLevelProduce;
        this.minTechLevelUse = minTechLevelUse;
        this.techLevelMost = techLevelMost;
        this.increacePerTechLevel = increacePerTechLevel;
        this.basePrice = basePrice;
        this.variance = variance;
        this.ie = ie;
        this.de = de;
        this.ee = ee;
        this.minPriceTrader = minPriceTrader;
        this.maxPriceTrader = maxPriceTrader;
    }

     public Integer getMinTechLevelProduce() {
         return minTechLevelProduce;
     }

     public Integer getMinTechLevelUse() {
         return minTechLevelUse;
     }

     public Integer getTechLevelMost() {
         return techLevelMost;
     }

     public Integer getIncreacePerTechLevel() {
         return increacePerTechLevel;
     }

     public Double getBasePrice() {
         return basePrice;
     }

     public Double getVariance() {
         return variance;
     }

     public IncreaseEvent getIe() {
         return ie;
     }

     public DecreaseEvent getDe() {
         return de;
     }

     public ExpensiveEvent getEe() {
         return ee;
     }

     public Integer getMinPriceTrader() {
         return minPriceTrader;
     }

     public Integer getMaxPriceTrader() {
         return maxPriceTrader;
     }

     public void setCode(Integer code) {
         this.code = code;
     }

     public void setMinTechLevelProduce(Integer minTechLevelProduce) {
         this.minTechLevelProduce = minTechLevelProduce;
     }

     public void setMinTechLevelUse(Integer minTechLevelUse) {
         this.minTechLevelUse = minTechLevelUse;
     }

     public void setTechLevelMost(Integer techLevelMost) {
         this.techLevelMost = techLevelMost;
     }

     public void setIncreacePerTechLevel(Integer increacePerTechLevel) {
         this.increacePerTechLevel = increacePerTechLevel;
     }

     public void setBasePrice(Double basePrice) {
         this.basePrice = basePrice;
     }

     public void setVariance(Double variance) {
         this.variance = variance;
     }

     public void setIe(IncreaseEvent ie) {
         this.ie = ie;
     }

     public void setDe(DecreaseEvent de) {
         this.de = de;
     }

     public void setEe(ExpensiveEvent ee) {
         this.ee = ee;
     }

     public void setMinPriceTrader(Integer minPriceTrader) {
         this.minPriceTrader = minPriceTrader;
     }

     public void setMaxPriceTrader(Integer maxPriceTrader) {
         this.maxPriceTrader = maxPriceTrader;
     }

     public Integer getCode() {
        return code;
    }
}
