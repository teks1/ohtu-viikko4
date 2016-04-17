import ohtu.*
import ohtu.authentication.*
import ohtu.form.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'A new user account can be created if a proper unused username and a proper password are given'

scenario "creation succesfull with correct username and password", {
    given 'command new user is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }
    when 'a valid username and password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("Pentti");
        element = driver.findElement(By.name("password"));
        element.sendKeys("1234567a");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("1234567a");
        element = driver.findElement(By.name("add"));
        element.submit();
    }
    then 'new user is registered to system', {
        driver.getPageSource().contains("info for newbie").shouldBe true
    }
}

scenario "can login with succesfully generated account", {
    given 'command new user is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }
 
    when 'a valid username and password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pentti2");
        element = driver.findElement(By.name("password"));
        element.sendKeys("1234567a2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("1234567a2");
        element = driver.findElement(By.name("add"));
        element.submit();
        element = driver.findElement(By.partialLinkText("continue"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
        element = driver.findElement(By.linkText("login"));       
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pentti2");
        element = driver.findElement(By.name("password"));
        element.sendKeys("1234567a2");
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    then  'new credentials allow logging in to system', {
        driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe true
    }
}

scenario "creation fails with correct username and too short password", {
    given 'command new user is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    when 'a valid username and too short password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pentti3");
        element = driver.findElement(By.name("password"));
        element.sendKeys("12a");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("12a");
        element = driver.findElement(By.name("add"));
        element.submit();
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("info for newbie").shouldBe false
    }
}

scenario "creation fails with correct username and password consisting of letters", {
    given 'command new user is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    when 'a valid username and password consisting of letters are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pentti4");
        element = driver.findElement(By.name("password"));
        element.sendKeys("abcabcabc");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("abcabcabc");
        element = driver.findElement(By.name("add"));
        element.submit();
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("info for newbie").shouldBe false
    }
}

scenario "creation fails with too short username and valid pasword", {
    given 'command new user is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    when 'a too sort username and valid password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("p");
        element = driver.findElement(By.name("password"));
        element.sendKeys("abcabcabc7");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("abcabcabc7");
        element = driver.findElement(By.name("add"));
        element.submit();
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("info for newbie").shouldBe false
    }
}

scenario "creation fails with already taken username and valid pasword", {
    given 'command new user is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    when 'a already taken username and valid password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("Pentti");
        element = driver.findElement(By.name("password"));
        element.sendKeys("1234567ab");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("1234567ab");
        element = driver.findElement(By.name("add"));
        element.submit();
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("info for newbie").shouldBe false
    }
}

scenario "can not login with account that is not succesfully created", {
    given 'command new user is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }
 
    when 'a invalid username/password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pentti23");
        element = driver.findElement(By.name("password"));
        element.sendKeys("a");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("a");
        element = driver.findElement(By.name("add"));
        element.submit();
        element = driver.findElement(By.partialLinkText("back"));
        element.click();
        element = driver.findElement(By.linkText("login"));       
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pentti22");
        element = driver.findElement(By.name("password"));
        element.sendKeys("a");
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    then  'new credentials do not allow logging in to system', {
        driver.getPageSource().contains("wrong username or password").shouldBe true
    }
}