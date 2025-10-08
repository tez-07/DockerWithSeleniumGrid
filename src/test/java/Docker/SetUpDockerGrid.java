package Docker;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetUpDockerGrid {

	private static final String OS = "mac";

	private String getStartCommand() {
        if (OS.contains("mac")) {
            return "/bin/bash ./start_dockergrid.sh"; 								// MacOS ARM64
        } else if (OS.contains("win")) {
            return "cmd /c start start_dockergrid.command"; 						// Windows
        } else {
            throw new UnsupportedOperationException("Unsupported OS: " + OS);
        }
    }

	
    private String getStopCommand() {
        if (OS.contains("mac")) {
            return "/bin/bash ./stop_dockergrid.sh"; 								// MacOS ARM64
        } else if (OS.contains("win")) {
            return "cmd /c stop stop_dockergrid.command"; 							// Windows
        } else {
            throw new UnsupportedOperationException("Unsupported OS: " + OS);
        }
    }

	@Test(priority=1)
    public void startDockerGrid() {
        try {
            System.out.println("Starting Docker Grid for OS: " + OS);
            Runtime.getRuntime().exec(getStartCommand());
            Thread.sleep(20000); 													// wait for grid to start
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority=2)
    public void stopDockerGrid() {
        try {
            System.out.println("Stopping Docker Grid for OS: " + OS);
            Runtime.getRuntime().exec(getStopCommand());
            Thread.sleep(20000); 													// wait for grid to stop

            // Only needed for Windows
            if (OS.contains("win")) {
                Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }		
}


