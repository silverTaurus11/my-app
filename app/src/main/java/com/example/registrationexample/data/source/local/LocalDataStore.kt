package com.example.registrationexample.data.source.local

import com.example.registrationexample.data.source.model.NewsModel

class LocalDataStore {

    companion object {
        @Volatile
        private var instance: LocalDataStore? = null

        fun getInstance(): LocalDataStore =
            instance ?: synchronized(this) {
                instance ?: LocalDataStore()
            }
    }

    fun getDummyData(): List<NewsModel>{
        return listOf(
            NewsModel("Modern-day enterprises implement a flurry of security measures " +
                    "to protect their IT infrastructure from ever-evolving threats . " +
                    "These security measures are present at multiple layers across the infrastructure to act as a " +
                    "strong deterrence to cyber attacks.", "Lifars.com", "2020-08-27",
                    listOf(
                        "https://i0.wp.com/lifars.com/wp-content/uploads/2020/08/Backup-Policy-vs-Backup-Plan-vs-Backup-Procedure.jpg?fit=1600%2C852&ssl=1",
                        "https://etimg.etb2bimg.com/thumb/msid-79203158,width-1200,resizemode-4/.jpg",
                        "https://i2.wp.com/lifars.com/wp-content/uploads/2020/08/DEF-CON-Hacking-Conference-Hunting-for-Blue-Mockingbird-Coinminers-presentation-by-Ladislav-B.jpg?resize=480%2C360&ssl=1"
                    )),
            NewsModel("Local Government Organizations Most Frequently Targeted by RansomwareLocal " +
                    "government bodies are more likely to be targeted by ransomware attacks than any other type of " +
                    "organization, according to a new study by Barracuda Networks," +
                    " which looked at 71 global ra…", "Newslocker.com", "2020-08-27",
                    listOf(
                        "https://www.kaspersky.com/content/en-global/images/repository/isc/2017-images/Ransomware-attacks-2017.jpg",
                        "https://brightlineit.com/wp-content/uploads/2017/10/171013-How-to-Detect-and-Prevent-Ransomware-Attacks.jpg",
                        "https://images.idgesg.net/images/article/2020/05/ransomware_attack_worried_businessman_by_andrey_popov_gettyimages-1199291222_cso_2400x1600-100840844-large.jpg"
                    )),
            NewsModel("On Monday, shares of the tech company will be one-fourth of their pre-split price. " +
                    "Is this a good buying opportunity?", "Motley Fool", "2020-08-26",
                    listOf(
                        "https://g.foolcdn.com/image/?url=https%3A%2F%2Fg.foolcdn.com%2Feditorial%2Fimages%2F589441%2Fshould-you-buy-apple-stock-after-split.jpg&w=1200&op=resize",
                        "https://g.foolcdn.com/image/?url=https%3A//g.foolcdn.com/editorial/images/589441/should-i-buy-apple-stock.jpg&w=2000&op=resize",
                        "https://g.foolcdn.com/editorial/images/589974/why-apple-stock-is-up.jpg"
                    )),
            NewsModel("The Last Campfire, the new game from No Man's Sky developer Hello Games, " +
                    "comes out on August 27th. It will be available on Apple Arcade, " +
                    "Nintendo Switch, PlayStation 4, Xbox One and Windows — " +
                    "where it'll be exclusive to the Epic Games Store. " +
                    "Beyond a Nintendo…", "Engadget", "2020-08-26",
                    listOf(
                        "https://i.ytimg.com/vi/R-XfZLzMasI/maxresdefault.jpg",
                        "https://www.androidcentral.com/sites/androidcentral.com/files/styles/large/public/article_images/2020/08/the-last-campfire-image.jpg",
                        "https://gamespot1.cbsistatic.com/uploads/screen_kubrick/1581/15811374/3684105-last%20campfire.jpg",
                        "https://blogs-images.forbes.com/erikkain/files/2018/12/Last-Campfire.jpg",
                        "https://cdn.vox-cdn.com/thumbor/-pdKPMzjoYkkybOYe8mYfX8bK_o=/0x0:2048x1152/1200x800/filters:focal(861x413:1187x739)/cdn.vox-cdn.com/uploads/chorus_image/image/62641162/lastcampfire.0.jpg"
                    )),
            NewsModel("Everyone’s habits have changed/are changing as a result of the pandemic, " +
                    "so marketers need to be testing and " +
                    "learning as quickly as possible.", "TechCrunch", "2020-08-25",
                    listOf(
                        "https://static.toiimg.com/photo/76507207.cms",
                        "https://image.cnbcfm.com/api/v1/image/106508187-medicalsurveillance_v2.jpg?v=1588017180&",
                        "https://static.politico.com/b6/64/b13e1e86467fa4233784ed18bb64/politico-friday-5-color.jpg"
                    ))
        )
    }
}