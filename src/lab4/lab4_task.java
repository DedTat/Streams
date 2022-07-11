/*Создать приложение с 3 потоками для следующей задачи: 
		3 работника выполняют следующую работу: 
			1-ый копает яму, 
			2-ой сажает дерево,  
			3-ий подвязывает саженец к кольям. 
	Работа идет строго по очереди. Число саженцев задается параметром.  
	Выводить на дисплей номер работника и номер саженца. 
*/

package lab4;

public class lab4_task {

    public void run(int timesdoit) {
        CurJob curJob = new CurJob(timesdoit);

        PlantThread plantThread = new PlantThread(curJob);
        DigThread digThread = new DigThread(curJob);
        TieUpThread tieUpThread = new TieUpThread(curJob);

        new Thread(digThread,"digThread").start();
        new Thread(plantThread,"plantThread").start();
        new Thread(tieUpThread,"tieUpThread").start();

    }
}
