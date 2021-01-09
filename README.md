# FBLA Coding & Programming Submission 2020-21
### Database & Storage
I initially planned on using a flat text file to store the questions for this project, but I eventually decided on a *PostgreSQL* database. The main reason for this was systematic
updates. If the database were to receive an update while multiple users had this program, the update wouldn't transfer over to all instances of the file. That being said, a PostgreSQL database could be accessed with the most updated information by all users, and from different machines. Security-wise, only a superuser would have the ability to change its contents, and it also, theoretically, could only be accessed by certain users by modifying the `pg_hba.conf` and `postgresql.conf` files to configure allowed IPs.

In terms of why I chose *PostgreSQL* over other web-based SQL data platforms (ie. MySQL, SQLite3, etc.) was just due to personal preference and experience.

### Graphical Interface
While I had little Java experience at the beginning of this project, I chose to utilize *JavaFX* since I felt it was more flexible than many Python-based GUIs that I was
initially looking into (and it allowed for more modernized designs). I also used *Gluon's Scene Builder*, so that I could have a direct visualization of changes I made to 
each scene's `.fxml` file, as well as my styling (CSS) sheet.

### Version Control
While I was the only developer of this project, I chose to periodically push my files to *Github* through `git` for two reasons: firstly, in case my computer decided to light on fire and fly out of the window, and secondly, so I could gain beginner experience with the platform.

### Output Reports
Rather than spending a great amount of time adding a section to the program where the user can customize the results of his/her quiz, I chose to output a flat text file. The
file itself contains all the necessary information to summarize the quiz, and due to it being `.txt`, can be plugged into any external document or graphical modifier. These include Microsoft Word, Adobe Acorbat, or even a high-end app like Adobe Photoshop.

###

### Dependencies/Tools Used
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (class and controller development)
- [Atom](https://atom.io/) (CSS development)
- [PostgreSQL](https://www.postgresql.org/)
- [JavaFX](https://openjfx.io/)
- [Gluon Scene Builder](https://gluonhq.com/products/scene-builder/)
- `git`
