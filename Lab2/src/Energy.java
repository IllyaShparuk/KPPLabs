public class Energy extends Unit {
    Energy() {
        units.put("fromJouleToFootPound", joule -> joule * 0.7375621493);
        units.put("fromFootPoundToJoule", ftLbf -> ftLbf * 1.3558179483);
        units.put("fromJouleToCalorie", joule -> joule * 0.2390057361);
        units.put("fromCalorieToJoule", calorie -> calorie * 4.184);
        units.put("fromFootPoundToCalorie", ftLbf -> ftLbf * 0.3240482668);
        units.put("fromCalorieToFoodPound", calorie -> calorie * 3.0859600327);
    }
}
