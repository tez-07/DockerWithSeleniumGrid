# 🐳 Docker + Selenium Grid Integration

This project demonstrates how to integrate **Docker** with **Selenium Grid** to run automated tests in parallel across multiple browser nodes.

---

## 1️⃣ Create the Docker Compose File

- Create a new file named **docker-compose.yaml** inside your project folder.  
- This file defines the Selenium Hub and Node containers.  
- All commands should be executed from this directory.  
- Reference: [Docker Hub - Selenium Images](https://hub.docker.com/u/selenium)

---

## 2️⃣ Run Selenium Grid

- Open the terminal and navigate to the folder where **docker-compose.yaml** is located.  
- Run the following command to start Selenium Hub and Nodes:  

  ```
  docker-compose up
  ```

- This command launches the Selenium Hub and connected browser nodes using Docker containers.

---

## 3️⃣ Verify Hub and Nodes

- After the containers start, open your browser and visit:  

  ```
  http://localhost:4444/grid/console
  ```

- You’ll see the Selenium Grid Console displaying active Hub and Node connections.  
- If containers were already running from a previous session, stop them first to avoid conflicts.

---

## 4️⃣ Scale Browser Nodes

- To increase the number of Chrome nodes (for example, to 3), open a new terminal window and execute:  

  ```
  docker-compose scale chrome=3
  ```

- This will spin up three Chrome node containers, enabling parallel test execution.

---

## 5️⃣ Configure TestNG for Parallel Testing

- Open your existing Selenium TestNG project or create a new one.  
- If **testng.xml** is not yet created:
  - Right-click on your package.  
  - Go to **TestNG → Convert to TestNG** to generate it.  

- Edit your **testng.xml** and update the suite tag as shown below:  

  ```xml
  <suite name="Selenium Grid Suite" parallel="classes" thread-count="3">
      <test name="Grid Tests">
          <classes>
              <class name="testpackage.YourTestClass"/>
          </classes>
      </test>
  </suite>
  ```

| Without Parallel Execution | With Parallel Execution |
|-----------------------------|--------------------------|
| Tests run sequentially | Tests run simultaneously across multiple nodes |

---

## 6️⃣ Stop All Containers

- To stop and remove all running Selenium Hub and Node containers, run:  

  ```
  docker-compose down
  ```

- This command will stop all services and clean up the containers.

---

## ✅ Summary

- Integrates **Docker** with **Selenium Grid** for automated browser testing.  
- Enables scalable and parallel test execution using multiple browser nodes.  
- Managed easily through **Docker Compose** for setup, scaling, and teardown.  

---

**Author:** *Tez Borgohain*  
**Tools Used:** Selenium • Docker • TestNG • Java 
