CREATE TABLE IF NOT EXISTS `city` (
   `city_id` int AUTO_INCREMENT PRIMARY KEY,
   `city_name` varchar(50) NOT NULL,
   `created_at` date NOT NULL,
   `created_by` varchar(20) NOT NULL,
   `updated_at` date DEFAULT NULL,
   `updated_by` varchar(20) DEFAULT NULL
);