

<p align="center">
  <a href="https://github.com/SumonSoftware">
    <img src="https://avatars.githubusercontent.com/u/168503949?s=400&u=0b6844ac4b6e0cba4ee7011daa2a1226deb0faff&v=4" alt="Logo" width="100" height="100">
  </a> 
   
<h1 align='center'>Join 3 Tables All Data Get</h1>

<!-- 
<h3 align='center'>
    <a href="https://www.youtube.com/watch?v=Sgkp46GS6rk">Watch Video</a> for Runtime Storage Permissions.  
</h3> -->
</p>



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
`
## In `MySQL Database Table Create Images` <br>
![Screenshot_30](https://github.com/SumonSoftware/Join3Tables-All-Data-Get-/assets/168503949/4964cdd4-77d3-44fd-a04e-cd261fc891d1)



## Step 3: In `BooksTable & AuthorsTable View for PHP Code` <br>

```php

<?php
header('Content-Type: application/json; charset=utf-8');

// Database connection parameters
$servername = "localhost";
$username = "databaseUerName";
$password = "databasePassword";
$database = "databaseName";

// Create connection
$conn = new mysqli($servername, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

// SQL query to retrieve data from BooksTable and related AuthorsTable data
$sql = "SELECT b.BooksTable_id, b.BooksTable_title, b.BooksTable_subTitle,
               a.AuthorsTable_id, a.AuthorsTable_title, a.AuthorsTable_subTitle
        FROM BooksTable b 
        LEFT JOIN AuthorsTable a ON b.BooksTable_id = a.BooksTable_id";

$result = $conn->query($sql);

// Check if there are any rows returned
if ($result->num_rows > 0) {
    // Initialize an empty array to store the results
    $data = array();

    // Loop through the result set
    while ($row = $result->fetch_assoc()) {
        $bookId = $row['BooksTable_id'];

        // Check if the book data already exists in the array
        if (!isset($data[$bookId])) {
            $data[$bookId] = array(
                'BooksTable_id' => $bookId,
                'BooksTable_title' => $row['BooksTable_title'],
                'BooksTable_subTitle' => $row['BooksTable_subTitle'],
                'Authors' => array()
            );
        }

        // Add author data to the book entry
        $data[$bookId]['Authors'][] = array(
            'AuthorsTable_id' => $row['AuthorsTable_id'],
            'AuthorsTable_title' => $row['AuthorsTable_title'],
            'AuthorsTable_subTitle' => $row['AuthorsTable_subTitle']
        );
    }

    // Free result set
    $result->free();

    // Close connection
    $conn->close();

    // Encode the array as JSON and print it
    echo json_encode(array_values($data)); // Convert associative array to sequential array
} else {
    echo "No data found";
}
?>


```


## Step 4: In `UserTable (search by AuthorsTable_id ) View for PHP Code` <br>

```php
<?php
header('Content-Type: application/json; charset=utf-8');

// Database connection parameters
$servername = "localhost";
$username = "databaseUerName";
$password = "databasePassword";
$database = "databaseName";

// Create connection
$conn = new mysqli($servername, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$AuthorsTable_id = $_GET['AuthorsTable_id'];

$sql = "SELECT * FROM UserTable WHERE AuthorsTable_id LIKE '$AuthorsTable_id' "; 
$result = mysqli_query($conn,$sql);
$rowcount= mysqli_num_rows($result);
$data = array();
foreach($result as $item){
    
         $UserTable_title = $item ['UserTable_title'];
         $UserTable_subTitle = $item ['UserTable_subTitle'];
         
        $info['title']= $UserTable_title;
        $info['subTitle']= $UserTable_subTitle;
 
   array_push($data,$info);
}
echo json_encode($data);

?>


```

## License

Distributed under the Apache License 2.0. See <a href="https://github.com/SumonSoftware/mone-tag/blob/main/LICENSE">LICENSE</a> for more information.


## Authors

**Sumon Islam** - *Android Software Developer* - <a href="https://github.com/SumonSoftware">Sumon Islam</a> - *Learn with Ease*

<h1 align="center">Thank You ❤️</h1>




