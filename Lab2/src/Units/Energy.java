package Units;

public class Energy extends Unit {
    public Energy() {
        units.put("From Joule To Foot-Pound", joule -> joule * 0.7375621493);
        units.put("From Foot-Pound To Joule", ftLbf -> ftLbf * 1.3558179483);
        units.put("From Joule To Calorie", joule -> joule * 0.2390057361);
        units.put("From Calorie To Joule", calorie -> calorie * 4.184);
        units.put("From Foot-Pound To Calorie", ftLbf -> ftLbf * 0.3240482668);
        units.put("From Calorie To Food-Pound", calorie -> calorie * 3.0859600327);
    }
}
