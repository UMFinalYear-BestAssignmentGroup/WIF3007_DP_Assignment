
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Melvin
 */
public class FoodBox extends VBox {

    FoodItem imageView;
    final int design_width;
    final int design_height;

    FoodItem yeesang;
    FoodItem dumplings;
    FoodItem ketupat;
    FoodItem rendang;

    Slider x_slider;
    Slider y_slider;
    Slider size_slider;

    ToggleButton btn_yeesang;
    ToggleButton btn_dumpling;
    ToggleGroup food_cny_toggle_btn;
    HBox food_cny_toggle;

    ToggleButton btn_ketupat;
    ToggleButton btn_rendang;
    ToggleGroup food_raya_toggle_btn;
    HBox food_raya_toggle;

    RadioButton btn_visible_true;
    RadioButton btn_visible_false;
    ToggleGroup visible_group;
    HBox visible_group_toggle;

    public FoodBox(Pane designPane, int design_width, int design_height) {
        this.design_height = design_height;
        this.design_width = design_width;

        //register fooditem
        yeesang = new YeeSang().setItem();
        dumplings = new Dumplings().setItem();
        ketupat = new Ketupat().setItem();
        rendang = new Rendang().setItem();
        designPane.getChildren().addAll(yeesang, dumplings, ketupat, rendang);

        //radio button to choose between Raya and CNY
        RadioButton btn_raya = new RadioButton("Raya");
        btn_raya.setUserData("raya");
        RadioButton btn_cny = new RadioButton("CNY");
        btn_cny.setUserData("cny");
        ToggleGroup food_radio_btn = new ToggleGroup();
        food_radio_btn.getToggles().addAll(btn_raya, btn_cny);
        HBox food_radio = new HBox(2);
        food_radio.setPadding(new Insets(5));
        food_radio.getChildren().addAll(btn_cny, btn_raya);

        //buttons to choose CNY foods
        btn_yeesang = new ToggleButton("Yee Sang");
        btn_yeesang.setUserData("yeesang");
        btn_dumpling = new ToggleButton("Dumplings");
        btn_dumpling.setUserData("dumplings");
        food_cny_toggle_btn = new ToggleGroup();
        food_cny_toggle_btn.getToggles().addAll(btn_yeesang, btn_dumpling);
        food_cny_toggle = new HBox(2);
        food_cny_toggle.setPadding(new Insets(5));
        food_cny_toggle.getChildren().addAll(btn_dumpling, btn_yeesang);

        //buttons to choose Raya foods
        btn_ketupat = new ToggleButton("Ketupat");
        btn_ketupat.setUserData("ketupat");
        btn_rendang = new ToggleButton("Rendang");
        btn_rendang.setUserData("rendang");
        food_raya_toggle_btn = new ToggleGroup();
        food_raya_toggle_btn.getToggles().addAll(btn_ketupat, btn_rendang);
        food_raya_toggle = new HBox(2);
        food_raya_toggle.setPadding(new Insets(5));
        food_raya_toggle.getChildren().addAll(btn_ketupat, btn_rendang);

        //buttons to choose food visibility
        btn_visible_true = new RadioButton("ON");
        btn_visible_true.setUserData(true);
        btn_visible_false = new RadioButton("OFF");
        btn_visible_false.setUserData(false);
        visible_group = new ToggleGroup();
        visible_group.getToggles().addAll(btn_visible_true, btn_visible_false);
        visible_group_toggle = new HBox(2);
        visible_group_toggle.setPadding(new Insets(5));
        visible_group_toggle.getChildren().addAll(btn_visible_true, btn_visible_false);

        //set visibility of button groups
        food_cny_toggle.setVisible(false);
        food_cny_toggle.setManaged(false);
        food_raya_toggle.setVisible(false);
        food_raya_toggle.setManaged(false);
        visible_group_toggle.setVisible(false);
        visible_group_toggle.setManaged(false);

        Text txt_x_axis = new Text("X_AXIS");
        Text txt_y_axis = new Text("Y_AXIS");
        Text txt_scale = new Text("SCALE");

        //set sliders
        x_slider = new Slider(0, 100, 0);
        y_slider = new Slider(0, 100, 0);
        size_slider = new Slider(100, 300, 200);

        x_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            if (imageView != null) {
                imageView.update(x_slider.getValue(), design_width - 150, "horizontal");
            }
        });

        y_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            if (imageView != null) {
                imageView.update(y_slider.getValue(), design_height - 100, "vertical");
            }
        });

        size_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            if (imageView != null) {
                imageView.update(size_slider.getValue());
            }
        });

        food_radio_btn.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (food_radio_btn.getSelectedToggle() != null) {
                System.out.println("Set to " + food_radio_btn.getSelectedToggle().getUserData().toString());
                switch (food_radio_btn.getSelectedToggle().getUserData().toString()) {
                    case "cny":
                        food_cny_toggle.setVisible(true);
                        food_cny_toggle.setManaged(true);
                        food_raya_toggle.setVisible(false);
                        food_raya_toggle.setManaged(false);
                        visible_group_toggle.setVisible(true);
                        visible_group_toggle.setManaged(true);
                        cnyFactory();
                        break;
                    case "raya":
                        food_cny_toggle.setVisible(false);
                        food_cny_toggle.setManaged(false);
                        food_raya_toggle.setVisible(true);
                        food_raya_toggle.setManaged(true);
                        visible_group_toggle.setVisible(true);
                        visible_group_toggle.setManaged(true);
                        rayaFactory();
                        break;
                }
            }
        });

        food_cny_toggle_btn.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            cnyFactory();
        });

        food_raya_toggle_btn.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            rayaFactory();
        });

        visible_group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (visible_group.getSelectedToggle() != null && imageView != null) {
                imageView.setVisibility(Boolean.parseBoolean(visible_group.getSelectedToggle().getUserData().toString()));
            }
        });

        setPadding(new Insets(10));
        getChildren().addAll(food_radio, food_cny_toggle, food_raya_toggle, visible_group_toggle, txt_x_axis, x_slider, txt_y_axis, y_slider, txt_scale, size_slider);
    }

    //set value for imageView and set sliders to imageView settings (CNY)
    public void cnyFactory() {
        List<Object> sliders;
        if (food_cny_toggle_btn.getSelectedToggle() != null) {
            switch (food_cny_toggle_btn.getSelectedToggle().getUserData().toString()) {
                case "yeesang":
                    imageView = yeesang;
                    sliders = imageView.getSlider();
                    x_slider.setValue((double) sliders.get(0));
                    y_slider.setValue((double) sliders.get(1));
                    size_slider.setValue((double) sliders.get(2));

                    if (imageView.getVisibility()) {
                        btn_visible_true.setSelected(true);
                        btn_visible_false.setSelected(false);
                    } else {
                        btn_visible_true.setSelected(false);
                        btn_visible_false.setSelected(true);
                    }
                    break;
                case "dumplings":
                    imageView = dumplings;
                    sliders = imageView.getSlider();
                    x_slider.setValue((double) sliders.get(0));
                    y_slider.setValue((double) sliders.get(1));
                    size_slider.setValue((double) sliders.get(2));

                    if (imageView.getVisibility()) {
                        btn_visible_true.setSelected(true);
                        btn_visible_false.setSelected(false);
                    } else {
                        btn_visible_true.setSelected(false);
                        btn_visible_false.setSelected(true);
                    }
                    break;
                default:
                    imageView = null;
                    break;
            }
        } else {
            imageView = null;
        }
    }

    //set value for imageView and set sliders to imageView settings (Raya)
    public void rayaFactory() {
        List<Object> sliders;
        if (food_raya_toggle_btn.getSelectedToggle() != null) {
            switch (food_raya_toggle_btn.getSelectedToggle().getUserData().toString()) {
                case "ketupat":
                    imageView = ketupat;
                    sliders = imageView.getSlider();
                    x_slider.setValue((double) sliders.get(0));
                    y_slider.setValue((double) sliders.get(1));
                    size_slider.setValue((double) sliders.get(2));

                    if (imageView.getVisibility()) {
                        btn_visible_true.setSelected(true);
                        btn_visible_false.setSelected(false);
                    } else {
                        btn_visible_true.setSelected(false);
                        btn_visible_false.setSelected(true);
                    }
                    break;
                case "rendang":
                    imageView = rendang;
                    sliders = imageView.getSlider();
                    x_slider.setValue((double) sliders.get(0));
                    y_slider.setValue((double) sliders.get(1));
                    size_slider.setValue((double) sliders.get(2));

                    if (imageView.getVisibility()) {
                        btn_visible_true.setSelected(true);
                        btn_visible_false.setSelected(false);
                    } else {
                        btn_visible_true.setSelected(false);
                        btn_visible_false.setSelected(true);
                    }
                    break;
                default:
                    imageView = null;
                    break;
            }
        } else {
            imageView = null;
        }
    }
}
