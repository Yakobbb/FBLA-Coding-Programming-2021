# FBLA Coding & Programming Submission 2020-21

### Database & Storage
I initially planned on using a flat text file to store the questions for this project, but I eventually decided on a *PostgreSQL* database. The main reason for this was systematic
updates. If the database were to receive an update while multiple users had this program, the update wouldn't transfer over to all instances of the file. That being said, a PostgreSQL database could be accessed with the most updated information by all users, and from different machines. Security-wise, only a superuser would have the ability to change its contents, and it also, theoretically, could only be accessed by certain users by modifying the `pg_hba.conf` and `postgresql.conf` files to configure allowed IPs.

In terms of why I chose *PostgreSQL* over other web-based SQL data platforms (ie. MySQL, SQLite3, etc.) was just due to personal preference and experience.

### Graphical Interface
While I had little experience with Java APIs at the beginning of this project, I chose to utilize *JavaFX* since I felt it was more flexible than many Python-based GUIs that I was
initially looking into (and it allowed for more modernized designs). I also used *Gluon's Scene Builder*, so that I could have a direct visualization of changes I made to 
each scene's `.fxml` file, as well as my styling (CSS) sheet.

### Version Control
While I was the only developer of this project, I chose to periodically push my files to *Github* through `git` for two reasons: firstly, in case my computer decided to light on fire and fly out of the window, and secondly, so I could gain more experience with the platform.

### Output Reports
Rather than spending a great amount of time adding a section to the program where the user can customize the results of his/her quiz, I chose to output a flat text file. The
file itself contains all the necessary information to summarize the quiz, and due to it being `.txt`, can be plugged into any external document or graphical modifier. These include Microsoft Word, Adobe Acrobat, or even a high-end app like Adobe Photoshop.

### User Interaction and Feedback
I initially had implemented a simple FAQs document within the directory of the program, but I felt that this didn't invite true user interaction.
So in addition to this, I utilized Oracle's *JavaMail* API to allow messages to be sent from within the program to an external email account. For this project,
I created a "dummy" email (fblaquizhelp2021@gmail.com) as a support line. With this added functionality, users can voice their questions and concerns, and receive a response
from the developer that is catered to their inquiry.

### Dependencies/Tools Used
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (class and controller development)
- [Atom](https://atom.io/) (CSS development)
- [PostgreSQL](https://www.postgresql.org/)
- [JavaFX](https://openjfx.io/)
- [Gluon Scene Builder](https://gluonhq.com/products/scene-builder/)
- [JavaMail](https://www.oracle.com/java/technologies/javamail.html)
- `git`

## NOTICE
None of the judges will be able go through a full quiz if running the `.JAR` file since I didn't put the database onto a public domain. The `QuestionLoader.java` class,
which accesses the database, does so by utilizing `localhost:5432` as a part of the server URL. With that being said, the main menu and help screens can be loaded.

## IDEA Project Folder Breakdown (FBLA_Quiz)
* The `.idea` and `resources` folders can be ignored (they were created as a result of this being an *IntelliJ* project, and through building the `.JAR`)
* All source files which I created can be found in `/src/sample` 
* Images used in the program can be found in `/src/images`
* The necessary `bash` arguments that I used to launch the program can be found in `VMConfigurations.txt` within the `/EXTRAS` folder (these arguments just pointed to where I had certain elements of the *JavaFX* library installed)
* My database backup, or dump file, is `dump.sql` and can be found within the `/EXTRAS` folder. This file can be run in a PostgreSQL shell to create a new copy of the database.
