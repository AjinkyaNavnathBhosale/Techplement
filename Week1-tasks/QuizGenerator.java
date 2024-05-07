import java.util.*;

class Question
{
    private static int Counter = 1;

    public int Number;
    public String Question;
    public String Option1;
    public String Option2;
    public String Option3;
    public String Option4;
    public String CorrectOption;

    public Question next;

    public Question(String Question,String OptionA,String OptionB,String OptionC,String OptionD,String CorrectOption)
    {
        Number = Counter;
        Counter++;

        this.Question = Question;
        this.Option1 = OptionA;
        this.Option2 = OptionB;
        this.Option3 = OptionC;
        this.Option4 = OptionD;
        this.CorrectOption = CorrectOption;
    }
}

class Quiz
{
    public Question first;

    public Quiz()
    {
        first = null;
        System.out.println("Basic Questions Quiz about Java language");
        System.out.println("Quizzes get Started...");
    }

    public void InsertMCQ(String Question, String OptionA, String OptionB, String OptionC, String OptionD, String CorrectOption)
    {
        Question nquestion = new Question(Question,OptionA,OptionB,OptionC,OptionD,CorrectOption);

        if(first == null)
        {
            first = nquestion;
        }
        else
        {
            Question temp = first;
            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = nquestion;
        }
    }
    
    public void TakeQuiz(String str)
    {   
        Scanner sobj = new Scanner(System.in);
        int CorrectAnswer = 0, WrongAnswer = 0;
        int TotleCount = 0, iCnt = 0;

        Question temp = first;
        
        while(temp != null)
        {
            TotleCount = temp.Number;
            
            System.out.println("--------------------------------------------------------------");
            System.out.println(temp.Number+") "+temp.Question+"\n"+temp.Option1+"\n"+temp.Option2+"\n"+temp.Option3+"\n"+temp.Option4+"\n");
            
            System.out.println("Enter Your answer : ");
            str = sobj.nextLine().toUpperCase();
            
            for(iCnt = 1; iCnt <= temp.Number; iCnt++)
            {
                if(temp.Number == iCnt)
                {
                    if(str.equals(temp.CorrectOption))
                    {
                        System.out.println("Correct Answer");
                        CorrectAnswer++;
                    }
                    else
                    {
                        System.out.println("Wrong Answer");
                        WrongAnswer--;
                    }
                }
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Your Result is : "+CorrectAnswer+"/"+TotleCount);
        System.out.println("Your Percentage is : "+(float)((float)CorrectAnswer/TotleCount*100));
        if(CorrectAnswer >= 6)
        {
            System.out.println("Congratulations ! Your Performnace are Great...");
        }
        else 
        {
            System.out.println("Keep practicing to improve your score...");
        }

    }
}

class QuizGenerator
{
    public static void main(String Arg[])
    {
        Scanner sobj = new Scanner(System.in);
        Quiz qobj = new Quiz();
        String str = "";
        
        qobj.InsertMCQ("Who is creator of java programming language ?","A: Dennis Ritchie","B: Ken Thompson","C: James Gosling","D: Bjarne Stroustrup","C");
        qobj.InsertMCQ("In which company the java programming language is developed ?","A: At & T Bell","B: Sun-Microsystems","C: Microsoft","D: Google","B");
        qobj.InsertMCQ("The Java programming language influence from which of the follwing languege ?","A: BCPL","B: C Sharp","C: Algol","D: C and C++","D");
        qobj.InsertMCQ("Which of the following is not a JAVA features ?","A: Dynamic","B: Architecture neutral","C: Use of pointers","D: Object-oriented","C");
        qobj.InsertMCQ("What was the initial name of java programming language ?","A: Java","B: Pam","C: Ook","D: Sumatra","C");
        qobj.InsertMCQ("What is the extention of java code files ?","A: .js","B: .txt","C: .class","D: .java","D");
        qobj.InsertMCQ("Which of the following option is true about java language ?","A: Platform-independent","B: Platform-dependent","C: Code-dependent","D: Sequence-dependent","A");
        qobj.InsertMCQ("Which of the following is not a non-premitive datatypes in java ?","A: Float","B: String","C: Array","D: Interface","A");
        qobj.InsertMCQ("What is the return value of main function in java ?","A: Int","B: void","C: Boolean","D: Float","B");
        qobj.InsertMCQ("What is the size of charactor datatype in java ?","A: 1 bit","B: 1 bytes","C: 4 bytes","D: 2 bytes","D");

        
        qobj.TakeQuiz(str);
    }
} 