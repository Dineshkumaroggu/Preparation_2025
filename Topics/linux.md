Absolutely! Let’s break down each **Linux command** more clearly — explaining:

* ✅ **What the command does**
* 🧠 **When/why you’d use it**
* 📌 **Example use-case (especially in support/debugging)**

---

## ✅ **Linux Commands – Explained with Use-Cases**

---

### 🔹 1. `ps aux`

* ✅ **What**: Lists **all running processes** on the system.
* 🧠 **Use when**: You want to find which processes are consuming CPU/memory or check if an app is running.
* 📌 **Example**: Check if your Java application is running.

```bash
ps aux | grep java
```

---

### 🔹 2. `top`

* ✅ **What**: Displays **live view** of CPU, memory, processes.
* 🧠 **Use when**: App is slow, you want to check system resource usage.
* 📌 **Example**: See which process is using the most CPU.

---

### 🔹 3. `lsof -i :8080`

* ✅ **What**: Shows which process is using **port 8080**.
* 🧠 **Use when**: Your app failed to start and might be due to **port already in use**.
* 📌 **Example**: Find process holding Tomcat port.

---

### 🔹 4. `kill <PID>` / `kill -9 <PID>`

* ✅ **What**: Sends signal to stop a process.

  * `kill -9`: Force kills (cannot be caught by process).
* 🧠 **Use when**: A process is stuck or unresponsive.
* 📌 **Example**: Kill a zombie Java process.

---

### 🔹 5. `pkill -f <name>`

* ✅ **What**: Kills a process by name or command line.
* 🧠 **Use when**: You don’t know the PID but know the app name.
* 📌 **Example**: Kill all processes matching `my-app.jar`.

---

### 🔹 6. `tail -f /path/to/logfile.log`

* ✅ **What**: Shows last lines of a log file, and **updates live**.
* 🧠 **Use when**: You’re troubleshooting an error — watch logs as app runs.
* 📌 **Example**: See live exceptions in `app.log`.

---

### 🔹 7. `df -h`

* ✅ **What**: Shows **disk space** usage per mounted filesystem.
* 🧠 **Use when**: Disk full errors or want to monitor server space.
* 📌 **Example**: Check `/var` disk is full due to log files.

---

### 🔹 8. `du -sh *`

* ✅ **What**: Shows **folder sizes** in current directory.
* 🧠 **Use when**: You need to find what's consuming space.
* 📌 **Example**: Identify large folders in `/logs`.

---

### 🔹 9. `free -m`

* ✅ **What**: Shows memory (RAM) usage in MB.
* 🧠 **Use when**: You suspect high memory usage.
* 📌 **Example**: Confirm memory spike when app crashes.

---

### 🔹 10. `chmod 755 filename.sh`

* ✅ **What**: Sets **file permissions** (read/write/execute).

  * `7` = read + write + execute
  * `5` = read + execute
* 🧠 **Use when**: You can’t execute a script — need to make it executable.
* 📌 **Example**: Make `deploy.sh` executable.

---

### 🔹 11. `whoami`

* ✅ **What**: Shows current logged-in **username**.
* 🧠 **Use when**: Scripts need to behave differently per user or debugging sudo issues.

---

### 🔹 12. `find / -name filename.txt`

* ✅ **What**: Searches the entire system for a file.
* 🧠 **Use when**: You forgot where a config or log file is.
* 📌 **Example**: Find `application.yml` in your project.

---

### 🔹 13. `export VAR=value`

* ✅ **What**: Sets a **temporary environment variable** in shell.
* 🧠 **Use when**: You want to set `JAVA_HOME`, `PATH`, etc. temporarily.
* 📌 **Example**: Export new `JAVA_HOME` for one session.

```bash
export JAVA_HOME=/usr/lib/jvm/java-17
```

---

### 🔹 14. `env` or `printenv`

* ✅ **What**: Lists current environment variables.
* 🧠 **Use when**: You want to check if a variable is set (e.g. `JAVA_HOME`).

---

### 🔹 15. `systemctl status servicename`

* ✅ **What**: Checks **status** of a service (active, failed, etc.)
* 🧠 **Use when**: Debugging if a system service (e.g. nginx, mysql) is up.
* 📌 **Example**:

```bash
systemctl status mysql
```

---

### 🔹 16. `crontab -e`

* ✅ **What**: Opens the **cron editor** to schedule recurring tasks.
* 🧠 **Use when**: You want to schedule backups, health checks, scripts.
* 📌 **Example**: Run a script every day at 3AM:

```bash
0 3 * * * /home/user/backup.sh
```

---

### 🔹 17. `uptime`

* ✅ **What**: Shows how long the server has been running.
* 🧠 **Use when**: You want to check for unexpected reboots or system restarts.

---

### 🔹 18. `lsof`

* ✅ **What**: Lists **open files and network sockets**.
* 🧠 **Use when**: Need to debug which files or sockets are held by which process.
* 📌 **Example**:

```bash
lsof | grep log
```

---

### 🔹 19. `tar -xzvf file.tar.gz`

* ✅ **What**: Extracts `.tar.gz` (compressed archive) files.

  * `x`: extract
  * `z`: gunzip
  * `v`: verbose
  * `f`: file
* 🧠 **Use when**: You receive backups, builds, or configs in compressed formats.

---

## 🧠 Final Tips for Interviews

> Focus on:

* File system navigation (`cd`, `ls`, `cat`)
* Log viewing and filtering (`tail`, `grep`, `less`)
* Process and port management (`ps`, `lsof`, `kill`)
* System health (`df`, `free`, `top`, `uptime`)
* Scripting basics and permissions

---

Would you like a cheat sheet with these for download, or flashcards for fast revision?
