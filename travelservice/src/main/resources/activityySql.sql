-- Create the database
CREATE DATABASE IF NOT EXISTS india_activities;
USE india_activities;

-- Create the 'activities' table
CREATE TABLE activities (
    activity_id INT PRIMARY KEY,
    activity_text TEXT,
    state_name VARCHAR(100),
    image_url VARCHAR(255)
);

-- Insert data into the 'activities' table
INSERT INTO activities (activity_id, activity_text, state_name, image_url)
VALUES
    -- Activities for Andhra Pradesh
    (1, 'Visit the beautiful Araku Valley for stunning landscapes.', 'Andhra Pradesh', 'https://tripsaround.in/wp-content/uploads/2014/08/Araku_Valley.jpg'),
    (2, 'Seek blessings at the famous Tirupati Temple.', 'Andhra Pradesh', 'https://www.tourmyindia.com/blog//wp-content/uploads/2021/06/Tirupati-Bala-Ji-Temple.jpg'),
    (3, 'Explore the fascinating Belum Caves.', 'Andhra Pradesh', 'https://www.freakouts.com/img/gallery/belum-caves.jpg'),

    -- Activities for Arunachal Pradesh
    (4, 'Visit the serene Tawang Monastery in Tawang.', 'Arunachal Pradesh', 'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/43/cf/85/monastery-view-from-city.jpg?w=1200&h=-1&s=1'),
    (5, 'Explore the historical ruins of Bomdila Monastery.', 'Arunachal Pradesh', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Bomdila_Monastery.jpg/800px-Bomdila_Monastery.jpg?20211130155358'),
    (6, 'Experience the breathtaking beauty of Sela Pass.', 'Arunachal Pradesh', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Tawang_Gate.jpg/250px-Tawang_Gate.jpg'),

    -- Activities for Assam
    (7, 'Embark on a wildlife adventure at Kaziranga National Park.', 'Assam', 'https://www.thestatesman.com/wp-content/uploads/2022/10/Untitled-design-2022-10-02T123819.443.jpg'),
    (8, 'Explore the largest river island, Majuli Island.', 'Assam', 'https://1.bp.blogspot.com/-LSMDsz9Pz8U/XK4OEQQfsMI/AAAAAAAAHpw/JcNIG4iCDZUCLTTmkU6iToaK9UT6XofnQCLcBGAs/s1600/FB_IMG_1554833904480.jpg'),
    (9, 'Visit the ancient Kamakhya Temple in Guwahati.', 'Assam', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Kamakhya_Guwahati.JPG/220px-Kamakhya_Guwahati.JPG'),

    -- Activities for Bihar
    (10, 'Visit the UNESCO World Heritage Site, Mahabodhi Temple in Bodh Gaya.', 'Bihar', 'https://bodhgaya.tourismindia.co.in/images/places-to-visit/header/mahabodhi-temple-bodh-gaya-tourism-entry-fee-timings-holidays-reviews-header.jpg'),
    (11, 'Explore the ancient Nalanda University Ruins.', 'Bihar', 'https://i1.wp.com/detechter.com/wp-content/uploads/2017/10/Nalanda.jpg?resize=758%2C486&ssl=1'),
    (12, 'Visit Takht Sri Patna Sahib, a famous Sikh pilgrimage site.', 'Bihar', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/TheJoyof350thAnniversary%40IncredibleIndia.jpg/250px-TheJoyof350thAnniversary%40IncredibleIndia.jpg'),

     -- Activities for Chhattisgarh
    (13, 'Witness the majestic Chitrakote Waterfalls, the "Niagara of India."', 'Chhattisgarh','https://static2.tripoto.com/media/filter/nl/img/375186/TripDocument/1504495447_1406181496_waterfalls_to_visit_in_the_monsoon_part_i_cox_kings_blog.jpg'),
    (14, 'Experience the vibrant Bastar Dussehra Festival.', 'Chhattisgarh','https://utsav.gov.in/public/uploads/event_cover_image/event_159/16522031181062255431.jpg'),
    (15, 'Visit the ancient Bhoramdeo Temple.', 'Chhattisgarh','https://www.chhattisgarhtourism.in/img1/Bhoramdeo/003.jpg'),

    -- Activities for Goa
    (16, 'Relax and enjoy the sun at Calangute Beach.', 'Goa', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Doodhsagar_Waterfalls.jpg/220px-Doodhsagar_Waterfalls.jpg'),
    (17, 'Visit the stunning Dudhsagar Waterfalls.', 'Goa', 'https://indiantripster.com/wp-content/uploads/2022/03/Untitled-design-2.png'),
    (18, 'Explore the historic Basilica of Bom Jesus in Old Goa.', 'Goa', 'https://www.holidify.com/images/cmsuploads/compressed/shutterstock_1073481062_20190822145857.jpg'),

    -- Activities for Gujarat
    (19, 'Explore the wildlife at Gir National Park, home to Asiatic lions.', 'Gujarat', 'http://www.tnhglobal.com/wp-content/uploads/2018/06/img_663c7ae20592ec4d0574d09cdc2a2982_1470804098308_original-1900x700_c.jpg'),
    (20, 'Experience the unique white desert landscape of the Rann of Kutch.', 'Gujarat', 'https://walkthewilderness.net/wp-content/uploads/2016/05/Rann-of-Kutch-White-Rann-1.jpg'),
    (21, 'Visit Sabarmati Ashram, associated with Mahatma Gandhi.', 'Gujarat', 'https://heritageofahmedabad.com/wp-content/uploads/2018/03/sabarmati-asharm-1.jpeg'),

    -- Activities for Haryana
    (22, 'Explore the bird sanctuary at Sultanpur National Park.', 'Haryana', 'https://haryanatourism.gov.in/WriteReadData/mediafiles/image/bird_pic1.jpg'),
    (23, 'Visit Kurukshetra, a place of historical and religious significance.', 'Haryana', 'https://images.tribuneindia.com/cms/gall_content/2017/11/2017_11$largeimg19_Sunday_2017_144106665.JPG'),
    (24, 'Enjoy the serene Badkhal Lake in Faridabad.', 'Haryana', 'https://pbs.twimg.com/media/EVtAzP6UcAEXei6?format=jpg&name=small'),


    -- Activities for Himachal Pradesh
    (25, 'Experience the scenic beauty of Rohtang Pass near Manali.', 'Himachal Pradesh', 'https://img.traveltriangle.com/blog/wp-content/uploads/2020/01/Rohtang-pass-in-summer_16th-jan.jpg'),
    (26, 'Explore the charming hill station of Manali.', 'Himachal Pradesh', 'https://tripsaround.in/wp-content/uploads/2014/09/Manali.jpg'),
    (27, 'Visit the picturesque town of Dalhousie.', 'Himachal Pradesh', 'https://images.cnbctv18.com/wp-content/uploads/2023/01/Dalhousie-1019x573.jpg?impolicy=website&width=617&height=264'),


    -- Activities for Telangana (including Hyderabad)
    (28, 'Explore the iconic Charminar in Hyderabad.', 'Telangana', 'https://w0.peakpx.com/wallpaper/363/5/HD-wallpaper-charminar-night-sky.jpg'),
    (29, 'Visit the historic Golconda Fort.', 'Telangana', 'https://assets-news.housing.com/news/wp-content/uploads/2020/11/02184143/Everything-you-need-to-know-about-Golconda-Fort-FB-1200x700-compressed.jpg'),
    (30, 'Spend a day at the sprawling Ramoji Film City.', 'Telangana', 'https://img.traveltriangle.com/attachments/pictures/1104496/original/Entrance_of_Ramoji_Film_City_at_Hayathnagar.jpg?tr=w-583,h-406');



