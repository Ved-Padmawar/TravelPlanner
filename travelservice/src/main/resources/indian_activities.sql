CREATE DATABASE india_activities;
USE india_activities;
CREATE TABLE activities (
    activity_id INT PRIMARY KEY,
    activity_text TEXT,
    activity_header TEXT,
    state_name VARCHAR(100),
    image_url VARCHAR(255)
);

INSERT INTO activities (activity_id, activity_header, activity_text, state_name, image_url)
VALUES
    (1,'Captivating', 'Visit the beautiful Araku Valley for stunning landscapes.', 'Andhra Pradesh', 'https://3.bp.blogspot.com/-uE97ZjbN3Dw/VvFEF6Z9IoI/AAAAAAAAFwQ/5czc564IiP4Jg8rjbgZvlUPTVQl6eIMYA/s1600/Araku%2BValley4.jpg'),
    (2,'Spiritual', 'Seek blessings at the famous Tirupati Temple.', 'Andhra Pradesh', 'https://www.tourmyindia.com/blog//wp-content/uploads/2021/06/Tirupati-Bala-Ji-Temple.jpg'),
    (3, 'Enthralling','Explore the fascinating Belum Caves.', 'Andhra Pradesh', 'https://www.freakouts.com/img/gallery/belum-caves.jpg'),

    (4, 'Tranquil','Visit the serene Tawang Monastery in Tawang.', 'Arunachal Pradesh', 'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/43/cf/85/monastery-view-from-city.jpg?w=1200&h=-1&s=1'),
    (5, 'Historic','Explore the historical ruins of Bomdila Monastery.', 'Arunachal Pradesh', 'https://i0.wp.com/www.eastmojo.com/wp-content/uploads/2021/02/arunachal.jpg?resize=1536%2C864&ssl=1'),
    (6,'Spectacular', 'Experience the breathtaking beauty of Sela Pass.', 'Arunachal Pradesh', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Tawang_Gate.jpg/250px-Tawang_Gate.jpg'),

    (7,'Thrilling', 'Embark on a wildlife adventure at Kaziranga National Park.', 'Assam', 'https://www.thestatesman.com/wp-content/uploads/2022/10/Untitled-design-2022-10-02T123819.443.jpg'),
    (8, 'Enchanting','Explore the largest river island, Majuli Island.', 'Assam', 'https://1.bp.blogspot.com/-LSMDsz9Pz8U/XK4OEQQfsMI/AAAAAAAAHpw/JcNIG4iCDZUCLTTmkU6iToaK9UT6XofnQCLcBGAs/s1600/FB_IMG_1554833904480.jpg'),
    (9, 'Mystical','Visit the ancient Kamakhya Temple in Guwahati.', 'Assam', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Kamakhya_Guwahati.JPG/220px-Kamakhya_Guwahati.JPG'),

    (10,'Sacred', 'Visit the UNESCO World Heritage Site, Mahabodhi Temple in Bodh Gaya.', 'Bihar', 'https://cf.cycle.in/cachewebp/data/Content/articles/Bodh-Gaya-Buddha-gaya-500x500.webp'),
    (11, 'Historic','Explore the ancient Nalanda University Ruins.', 'Bihar', 'https://i1.wp.com/detechter.com/wp-content/uploads/2017/10/Nalanda.jpg?resize=758%2C486&ssl=1'),
    (12, 'Revered','Visit Takht Sri Patna Sahib, a famous Sikh pilgrimage site.', 'Bihar', 'https://media.newstrack.in/uploads/other-news/religion-news-info/Jun/30/big_thumb/patna-sahib-ji_649e6e656a365.JPG'),

    (13, 'Breathtaking','Witness the majestic Chitrakote Waterfalls, the "Niagara of India."', 'Chhattisgarh','https://static2.tripoto.com/media/filter/nl/img/375186/TripDocument/1504495447_1406181496_waterfalls_to_visit_in_the_monsoon_part_i_cox_kings_blog.jpg'),
    (14,'Lively', 'Experience the vibrant Bastar Dussehra Festival.', 'Chhattisgarh','https://utsav.gov.in/public/uploads/event_cover_image/event_159/16522031181062255431.jpg'),
    (15, 'Archaeological','Visit the ancient Bhoramdeo Temple.', 'Chhattisgarh','https://www.chhattisgarhtourism.in/img1/Bhoramdeo/003.jpg'),

    (16,'Idyllic', 'Relax and enjoy the sun at Calangute Beach.', 'Goa', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Doodhsagar_Waterfalls.jpg/220px-Doodhsagar_Waterfalls.jpg'),
    (17,'Majestic', 'Visit the stunning Dudhsagar Waterfalls.', 'Goa', 'https://indiantripster.com/wp-content/uploads/2022/03/Untitled-design-2.png'),
    (18, 'Revered','Explore the historic Basilica of Bom Jesus in Old Goa.', 'Goa', 'https://www.holidify.com/images/cmsuploads/compressed/shutterstock_1073481062_20190822145857.jpg'),

    (19,'Exotic', 'Explore the wildlife at Gir National Park, home to Asiatic lions.', 'Gujarat', 'http://www.tnhglobal.com/wp-content/uploads/2018/06/img_663c7ae20592ec4d0574d09cdc2a2982_1470804098308_original-1900x700_c.jpg'),
    (20,'Captivating', 'Experience the unique white desert landscape of the Rann of Kutch.', 'Gujarat', 'https://walkthewilderness.net/wp-content/uploads/2016/05/Rann-of-Kutch-White-Rann-1.jpg'),
    (21,'Historical', 'Visit Sabarmati Ashram, associated with Mahatma Gandhi.', 'Gujarat', 'https://heritageofahmedabad.com/wp-content/uploads/2018/03/sabarmati-asharm-1.jpeg'),

    (22,'Avian', 'Explore the bird sanctuary at Sultanpur National Park.', 'Haryana', 'https://haryanatourism.gov.in/WriteReadData/mediafiles/image/bird_pic1.jpg'),
    (23,'Reverent', 'Visit Kurukshetra, a place of historical and religious significance.', 'Haryana', 'https://assets-news.housing.com/news/wp-content/uploads/2022/09/14081240/Tourist-places-in-Kurukshetra.jpg'),
    (24,'Tranquil', 'Enjoy the serene Badkhal Lake in Faridabad.', 'Haryana', 'https://pbs.twimg.com/media/EVtAzP6UcAEXei6?format=jpg&name=small'),

    (25,'Breathtaking', 'Experience the scenic beauty of Rohtang Pass near Manali.', 'Himachal Pradesh', 'https://img.traveltriangle.com/blog/wp-content/uploads/2020/01/Rohtang-pass-in-summer_16th-jan.jpg'),
    (26,'Enchanting', 'Explore the charming hill station of Manali.', 'Himachal Pradesh', 'https://www.tourmyindia.com/states/himachal/image/manali-tour-package-s1.webp'),
    (27,'Scenic', 'Visit the picturesque town of Dalhousie.', 'Himachal Pradesh', 'https://images.cnbctv18.com/wp-content/uploads/2023/01/Dalhousie-1019x573.jpg?impolicy=website&width=617&height=264'),

    (28,'Historical', 'Explore the iconic Charminar in Hyderabad.', 'Telangana', 'https://w0.peakpx.com/wallpaper/363/5/HD-wallpaper-charminar-night-sky.jpg'),
    (29,'Majestic', 'Visit the historic Golconda Fort.', 'Telangana', 'https://assets-news.housing.com/news/wp-content/uploads/2020/11/02184143/Everything-you-need-to-know-about-Golconda-Fort-FB-1200x700-compressed.jpg'),
    (30, 'Entertaining','Spend a day at the sprawling Ramoji Film City.', 'Telangana', 'https://img.traveltriangle.com/attachments/pictures/1104496/original/Entrance_of_Ramoji_Film_City_at_Hayathnagar.jpg?tr=w-583,h-406');