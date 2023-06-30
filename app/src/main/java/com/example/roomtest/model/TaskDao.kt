package com.example.roomtest.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

// SE DECLARÁN LOS MÉTODOS PARA OPERAR CON LA BASE DE DATOS, CREAR, LEER, ESCRIBIR, UPDATE, BORRAR
@Dao
interface TaskDao {
    // Insertar una tarea tiene una estrategia si se repite el Id
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    // Insertar listado de tareas
    @Insert
    fun insertTMultipleTask(list:List<Task>)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteOneTask(task: Task)

    @Query("SELECT * FROM TASK_TABLE")
    fun getAllTask1():List<Task>

    @Query("SELECT * FROM TASK_TABLE ORDER BY idTask ASC")
    fun getAllTask():List<Task>

    /*
    @Query("SELECT * FROM TASK_TABLE WHERE task= task Limit 1 ")
    fun getAllTask1(task: String):Task
     */

    /*
    @Query("SELECT * FROM TASK_TABLE WHERE idTask= idTask Limit 1")
    fun getllTaskByid(idTask: Int):Task
     */
}