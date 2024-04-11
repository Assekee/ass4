import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NutritionPlan {
    private int caloricIntake;
    private int carbohydratesRatio;
    private int proteinsRatio;
    private int fatsRatio;
    private List<String> mealPlans;
    private String fitnessGoal;
    private List<String> dietaryRestrictions;


    public NutritionPlan() {}


    public int getCaloricIntake() {
        return caloricIntake;
    }

    public void setCaloricIntake(int caloricIntake) {
        this.caloricIntake = caloricIntake;
    }

    public int getCarbohydratesRatio() {
        return carbohydratesRatio;
    }

    public void setCarbohydratesRatio(int carbohydratesRatio) {
        this.carbohydratesRatio = carbohydratesRatio;
    }

    public int getProteinsRatio() {
        return proteinsRatio;
    }

    public void setProteinsRatio(int proteinsRatio) {
        this.proteinsRatio = proteinsRatio;
    }

    public int getFatsRatio() {
        return fatsRatio;
    }

    public void setFatsRatio(int fatsRatio) {
        this.fatsRatio = fatsRatio;
    }

    public List<String> getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(List<String> mealPlans) {
        this.mealPlans = mealPlans;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public List<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(List<String> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

}


class NutritionPlanBuilder {
    private NutritionPlan nutritionPlan;

    public NutritionPlanBuilder() {
        this.nutritionPlan = new NutritionPlan();
    }

    public NutritionPlanBuilder setCaloricIntake(int caloricIntake) {
        nutritionPlan.setCaloricIntake(caloricIntake);
        return this;
    }

    public NutritionPlanBuilder setMacronutrientRatios(int carbohydratesRatio, int proteinsRatio, int fatsRatio) {
        nutritionPlan.setCarbohydratesRatio(carbohydratesRatio);
        nutritionPlan.setProteinsRatio(proteinsRatio);
        nutritionPlan.setFatsRatio(fatsRatio);
        return this;
    }

    public NutritionPlanBuilder setMealPlans(List<String> mealPlans) {
        nutritionPlan.setMealPlans(mealPlans);
        return this;
    }

    public NutritionPlanBuilder setFitnessGoal(String fitnessGoal) {
        nutritionPlan.setFitnessGoal(fitnessGoal);
        return this;
    }

    public NutritionPlanBuilder setDietaryRestrictions(List<String> dietaryRestrictions) {
        nutritionPlan.setDietaryRestrictions(dietaryRestrictions);
        return this;
    }

    public NutritionPlan build() {
        return nutritionPlan;
    }
}


class NutritionPlanDirector {
    private NutritionPlanBuilder builder;

    public void setBuilder(NutritionPlanBuilder builder) {
        this.builder = builder;
    }

    public NutritionPlan createNutritionPlan() {
        return builder.setCaloricIntake(2000)
                .setMacronutrientRatios(50, 30, 20)
                .setMealPlans(Arrays.asList("Breakfast: Oatmeal", "Lunch: Grilled Chicken Salad", "Dinner: Baked Salmon"))
                .setFitnessGoal("weight loss")
                .setDietaryRestrictions(Arrays.asList("gluten-free"))
                .build();
    }
}


public class ass4 {
    public static void main(String[] args) {
        NutritionPlanDirector director = new NutritionPlanDirector();

      
        director.setBuilder(new WeightLossNutritionPlanBuilder());
        NutritionPlan nutritionPlan = director.createNutritionPlan();

        System.out.println("Caloric Intake: " + nutritionPlan.getCaloricIntake());
        System.out.println("Meal Plans: " + nutritionPlan.getMealPlans());
        System.out.println("Fitness Goal: " + nutritionPlan.getFitnessGoal());
        System.out.println("Dietary Restrictions: " + nutritionPlan.getDietaryRestrictions());
    }

    private static class WeightLossNutritionPlanBuilder extends NutritionPlanBuilder {
    }
}
