public class DriversLicenseExam
{
    private String[] correctAnswers = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D"};
    private String[] userAnswers;
    int[] missed = new int[correctAnswers.length];

    public DriversLicenseExam (String[] Answers)
    {
        userAnswers = new String[Answers.length];
        for (int i = 0; i< Answers.length; i++)
        {
            userAnswers[i] = Answers[i];
        }
    }
    public boolean passed()
    {
        if (totalCorrect() >= 7)
            return true;
        else
            return false;
    }
    public int totalCorrect()
    {
        int correctCount = 0;
        for (int i = 0; i<correctAnswers.length; i++)
        {
            if (userAnswers[i].equalsIgnoreCase(correctAnswers[i]))
            {
                correctCount++;
            }
        }
        return correctCount;
    }
    public int totalIncorrect()
    {
        int incorrectCount = 0;
        for (int i=0; i<correctAnswers.length; i++)
        {
            if(!userAnswers[i].equalsIgnoreCase(correctAnswers[i]))
            {
                missed[incorrectCount] = i;
                incorrectCount++;
            }
        }
        return incorrectCount;
    }
    public int[] questionsMissed()
    {
        return missed;
    }

}