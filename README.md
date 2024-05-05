<h3> Join 3 Tables All Data Get</h3>


## Step 1: In `AndroidManifest.xml` <br>

`Add below Permissions.`
```xml
   
 <!-- Ad And Internet Permission -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />

```
## Step 2: In `MySQL Database Table Create` <br>

```mysqldatabase
CREATE TABLE BooksTable (
    BooksTable_id INT AUTO_INCREMENT PRIMARY KEY,
    BooksTable_title VARCHAR(255),
    BooksTable_subTitle VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE AuthorsTable (
    AuthorsTable_id INT AUTO_INCREMENT PRIMARY KEY,
    AuthorsTable_title VARCHAR(255),
    AuthorsTable_subTitle VARCHAR(255),
    BooksTable_id INT,
    FOREIGN KEY (BooksTable_id) REFERENCES BooksTable(BooksTable_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE UserTable (
    UserTable_id INT AUTO_INCREMENT PRIMARY KEY,
    UserTable_title VARCHAR(255),
    UserTable_subTitle VARCHAR(255),
    AuthorsTable_id INT,
    FOREIGN KEY (AuthorsTable_id) REFERENCES AuthorsTable(AuthorsTable_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

```

## Step 3: Here is MainActivity.java code:` <br>



