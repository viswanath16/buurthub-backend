CREATE TABLE IF NOT EXISTS `city` (
   `city_id` int AUTO_INCREMENT PRIMARY KEY,
   `city_name` varchar(50) NOT NULL,
   `created_at` date NOT NULL,
   `created_by` varchar(20) NOT NULL,
   `updated_at` date DEFAULT NULL,
   `updated_by` varchar(20) DEFAULT NULL
);


CREATE TABLE IF NOT EXISTS `event` (
    `event_id` int AUTO_INCREMENT PRIMARY KEY,
    `title` varchar(255) NOT NULL,
    `date` date NOT NULL,
    `address` varchar(255) NOT NULL,
    `location_url` varchar(255),
    `location_type` varchar(10) NOT NULL DEFAULT 'Point',
    `latitude` double NOT NULL,
    `longitude` double NOT NULL,
    `image` varchar(255) NOT NULL,
    `description` text NOT NULL,
    `organiser` varchar(255) NOT NULL,
    `city` varchar(255),
    `time` varchar(50),
    `price` enum('Paid', 'Free'),
    `category` enum('Art and Culture', 'Health and Wellness',
                    'Entertainment', 'Sports',
                    'Technology', 'Education',
                    'Community & Environment', 'Career'),
    `participants` json,
    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);


CREATE TABLE IF NOT EXISTS `product` (
    `product_id` INT AUTO_INCREMENT PRIMARY KEY,
    `city` VARCHAR(255) NOT NULL,
    `product_name` VARCHAR(255) NOT NULL,
    `price` DECIMAL(10, 2) NOT NULL,
    `image` VARCHAR(255),
    `description` TEXT,
    `condition` VARCHAR(255),
    `product_owner` VARCHAR(255),
    `category` VARCHAR(255),
    `reserved_by_id` VARCHAR(255),
    `favourite_by_id` VARCHAR(255),
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);