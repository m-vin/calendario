import java.time.LocalDate;
import java.time.DayOfWeek;

public class Calendario {

	public static void geraCalendario(int mes, int ano){
		int i;
		System.out.println("Calendário para o mês " + mes + " do ano " + ano);
		System.out.println("Dom  Seg  Ter  Qua  Qui  Sex  Sáb");

		LocalDate date = LocalDate.of(ano, mes, 1);
		DayOfWeek weekday = DayOfWeek.from(date);
		for (i = 1; i <= weekday.getValue(); i++)
			System.out.print(" -   ");

		while (date.getMonthValue() == mes){
			System.out.printf("%2d   ", date.getDayOfMonth());
			if (i % 7 == 0){
				System.out.println();
			}
			i++;
			date = date.plusDays(1);
		}
		System.out.println();
	}

	public static void main(String[] args){
		if (args.length < 2)
			System.out.println("java Calendario <mes> <ano>");
		else if (Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[0]) > 12)
			System.out.println("O mês deve ser maior ou igual a 1 e menor ou igual a 12.");
		else if (Integer.parseInt(args[1]) < 1970 || Integer.parseInt(args[1]) > 2019)
			System.out.println("O ano deve ser maior ou igual a 1970 e menor ou igual a 2019.");
		else {
			geraCalendario(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		}
	}
}