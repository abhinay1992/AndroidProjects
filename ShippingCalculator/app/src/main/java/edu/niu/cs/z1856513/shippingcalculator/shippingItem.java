package edu.niu.cs.z1856513.shippingcalculator;

public class shippingItem
    {

        //constants
        static final double BASE_AMOUNT = 3.00 ,
                            ADDED_AMOUNT = 0.50,
                            EXTRA_OUNCES = 4.0;

        static final int BASE_WEIGHT = 16;

        //variables

        private int weight;
        private double baseCost, addedCost, totalCost;

        public shippingItem()
            {
                weight = 0;
                baseCost = BASE_AMOUNT;
                addedCost = 0.0;
                totalCost = 0.0;
            }

        public void setWeight(int weight)
            {
                this.weight = weight;
                computeCost();
            }

        public void computeCost()
            {
                baseCost = BASE_AMOUNT;
                if(weight < 0)
                    baseCost=0;

                //calculate additional cost
                addedCost=0.0;

                if(weight > BASE_WEIGHT)
                    addedCost = Math.ceil((weight - BASE_WEIGHT)/EXTRA_OUNCES) * ADDED_AMOUNT ;

                //total cost
                totalCost = baseCost + addedCost;

            }

        public double getBaseCost()
            {
                return baseCost;
            }

        public double getAddedCost()
            {
                return addedCost;
            }

        public double getTotalCost()
            {
                return totalCost;
            }
    }
