package ui_Layer;

import core.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Igor on 8/22/2018.
 */
public class BasePage {

    public BasePage()
    {
        PageFactory.initElements(Driver.get(), this);
    }

    //Actions action = new Actions(Driver.get());
}
