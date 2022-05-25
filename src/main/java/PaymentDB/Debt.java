package PaymentDB;

public class Debt{

   private int ID;
   private float amount;

   public int getID() {
      return ID;
   }

   public void setID(int ID) {
      this.ID = ID;
   }

   public float getAmount() {
      return amount;
   }

   public void setAmount(float amount) {
      this.amount = amount;
   }

   public Debt(int ID, float amount) {
      this.ID = ID;
      this.amount = amount;
   }
}
