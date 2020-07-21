package edu.niu.cs.z1856513.imagesanddynamiclayout;

public class Character
    {
        private String charDescription;
        private int charID;

        public Character(String charDescription, int charID) {
            this.charDescription = charDescription;
            this.charID = charID;
        }

        public String getCharDescription() {
            return charDescription;
        }

        public void setCharDescription(String charDescription) {
            this.charDescription = charDescription;
        }

        public int getCharID() {
            return charID;
        }

        public void setCharID(int charID) {
            this.charID = charID;
        }
    }
