
create database india_activities;
USE india_activities;

CREATE TABLE activities (
    activity_id INT PRIMARY KEY,
    activity_text TEXT,
    state_name VARCHAR(100)
);

INSERT INTO activities (activity_id, activity_text, state_name)
VALUES
    -- Activities for Andhra Pradesh
    (1, 'Visit the beautiful Araku Valley for stunning landscapes.', 'Andhra Pradesh'),
    (2, 'Seek blessings at the famous Tirupati Temple.', 'Andhra Pradesh'),
    (3, 'Explore the fascinating Belum Caves.', 'Andhra Pradesh'),

    -- Activities for Arunachal Pradesh
    (4, 'Visit the serene Tawang Monastery in Tawang.', 'Arunachal Pradesh'),
    (5, 'Explore the historical ruins of Bomdila Monastery.', 'Arunachal Pradesh'),
    (6, 'Experience the breathtaking beauty of Sela Pass.', 'Arunachal Pradesh'),

    -- Activities for Assam
    (7, 'Embark on a wildlife adventure at Kaziranga National Park.', 'Assam'),
    (8, 'Explore the largest river island, Majuli Island.', 'Assam'),
    (9, 'Visit the ancient Kamakhya Temple in Guwahati.', 'Assam'),

    -- Activities for Bihar
    (10, 'Visit the UNESCO World Heritage Site, Mahabodhi Temple in Bodh Gaya.', 'Bihar'),
    (11, 'Explore the ancient Nalanda University Ruins.', 'Bihar'),
    (12, 'Visit Takht Sri Patna Sahib, a famous Sikh pilgrimage site.', 'Bihar'),

    -- Activities for Chhattisgarh
    (13, 'Witness the majestic Chitrakote Waterfalls, the "Niagara of India."', 'Chhattisgarh'),
    (14, 'Experience the vibrant Bastar Dussehra Festival.', 'Chhattisgarh'),
    (15, 'Visit the ancient Bhoramdeo Temple.', 'Chhattisgarh'),

    -- Activities for Goa
    (16, 'Relax and enjoy the sun at Calangute Beach.', 'Goa'),
    (17, 'Visit the stunning Dudhsagar Waterfalls.', 'Goa'),
    (18, 'Explore the historic Basilica of Bom Jesus in Old Goa.', 'Goa'),

    -- Activities for Gujarat
    (19, 'Explore the wildlife at Gir National Park, home to Asiatic lions.', 'Gujarat'),
    (20, 'Experience the unique white desert landscape of the Rann of Kutch.', 'Gujarat'),
    (21, 'Visit Sabarmati Ashram, associated with Mahatma Gandhi.', 'Gujarat'),

    -- Activities for Haryana
    (22, 'Explore the bird sanctuary at Sultanpur National Park.', 'Haryana'),
    (23, 'Visit Kurukshetra, a place of historical and religious significance.', 'Haryana'),
    (24, 'Enjoy the serene Badkhal Lake in Faridabad.', 'Haryana'),

    -- Activities for Himachal Pradesh
    (25, 'Experience the scenic beauty of Rohtang Pass near Manali.', 'Himachal Pradesh'),
    (26, 'Explore the charming hill station of Manali.', 'Himachal Pradesh'),
    (27, 'Visit the picturesque town of Dalhousie.', 'Himachal Pradesh'),

    -- Activities for Telangana (including Hyderabad)
    (28, 'Explore the iconic Charminar in Hyderabad.', 'Telangana'),
    (29, 'Visit the historic Golconda Fort.', 'Telangana'),
    (30, 'Spend a day at the sprawling Ramoji Film City.', 'Telangana');


