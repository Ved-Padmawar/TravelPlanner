CREATE database india_activities;
USE india_activities;
CREATE TABLE states (
    state_id INT PRIMARY KEY,
    state_name VARCHAR(50) NOT NULL
);
INSERT INTO states (state_id, state_name)
VALUES
    (1, 'Andhra Pradesh'),
    (2, 'Arunachal Pradesh'),
    (3, 'Assam'),
    (4, 'Bihar'),
    (5, 'Chhattisgarh'),
    (6, 'Goa'),
    (7, 'Gujarat'),
    (8, 'Haryana'),
    (9, 'Himachal Pradesh'),
    (10, 'Telangana'); 


    
    CREATE TABLE recommendations (
    recommendation_id INT PRIMARY KEY,
    recommendation_text TEXT,
    state_id INT,
    FOREIGN KEY (state_id) REFERENCES states(state_id)
);

INSERT INTO recommendations (recommendation_id, recommendation_text, state_id)
VALUES

    (1, 'Visit the beautiful Araku Valley for stunning landscapes.', 1),
    (2, 'Seek blessings at the famous Tirupati Temple.', 1),
    (3, 'Explore the fascinating Belum Caves.', 1),

    (4, 'Visit the serene Tawang Monastery in Tawang.', 2),
    (5, 'Explore the historical ruins of Bomdila Monastery.', 2),
    (6, 'Experience the breathtaking beauty of Sela Pass.', 2),

    
    (7, 'Embark on a wildlife adventure at Kaziranga National Park.', 3),
    (8, 'Explore the largest river island, Majuli Island.', 3),
    (9, 'Visit the ancient Kamakhya Temple in Guwahati.', 3),

    
    (10, 'Visit the UNESCO World Heritage Site, Mahabodhi Temple in Bodh Gaya.', 4),
    (11, 'Explore the ancient Nalanda University Ruins.', 4),
    (12, 'Visit Takht Sri Patna Sahib, a famous Sikh pilgrimage site.', 4),

    (13, 'Witness the majestic Chitrakote Waterfalls, the "Niagara of India."', 5),
    (14, 'Experience the vibrant Bastar Dussehra Festival.', 5),
    (15, 'Visit the ancient Bhoramdeo Temple.', 5),

    (16, 'Relax and enjoy the sun at Calangute Beach.', 6),
    (17, 'Visit the stunning Dudhsagar Waterfalls.', 6),
    (18, 'Explore the historic Basilica of Bom Jesus in Old Goa.', 6),

    (19, 'Explore the wildlife at Gir National Park, home to Asiatic lions.', 7),
    (20, 'Experience the unique white desert landscape of the Rann of Kutch.', 7),
    (21, 'Visit Sabarmati Ashram, associated with Mahatma Gandhi.', 7),

    (22, 'Explore the bird sanctuary at Sultanpur National Park.', 8),
    (23, 'Visit Kurukshetra, a place of historical and religious significance.', 8),
    (24, 'Enjoy the serene Badkhal Lake in Faridabad.', 8),

    (25, 'Experience the scenic beauty of Rohtang Pass near Manali.', 9),
    (26, 'Explore the charming hill station of Manali.', 9),
    (27, 'Visit the picturesque town of Dalhousie.', 9),

    (28, 'Explore the iconic Charminar in Hyderabad.', 10),
    (29, 'Visit the historic Golconda Fort.', 10),
    (30, 'Spend a day at the sprawling Ramoji Film City.', 10);