package com.example.personapp.di


import android.content.Context
import androidx.room.Room
import com.example.personapp.data.repo.PersonDaoRepository
import com.example.personapp.room.Database
import com.example.personapp.room.PersonsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonDaoRepository(pdao:PersonsDao) : PersonDaoRepository{
        return PersonDaoRepository(pdao)
    }
    @Provides
    @Singleton
    fun providePersonsDao(@ApplicationContext context: Context) : PersonsDao {
        val db = Room.databaseBuilder(context,Database::class.java,"directory.sqlite")
            .createFromAsset("directory.sqlite").build()
        return db.getPersonsDao()
    }
}
