   M S B A M L   `   `   `  ����G  CDeansOffice1, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null+clr-namespace:DeansOffice1DeansOffice1  5   	       DeansOffice1.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   ,localclr-namespace:DeansOffice1     5   	     � Title$  
MainWindow��5   	   $��475.2��6   $��753.2��6+   .��5	      � .+�5   
   �� $��10,75,504.2,304.6q�6   $��28(�6+   $��Lista studentów��69   �� 5   
   $��18(�6   $��10,36,683.2,375.6q�6   $	��200��69   .��6F   Plik6L   &   System.Windows.Controls.DataGrid  5   
   -   5        $��StudentsDataGrid��5         AutoGenerateColumns .  $
��Left=�5      $	��239��6.   $��	0,130,0,0q�6;   $	��Top=�6N      CanUserAddRows .  $	��350��5      $	��750��6"   $	��747��61      Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   MinWidth$ 40Q�6%      Header$ Nazwisko��63      MaxWidth$ 90Q�6E   1  +System.Windows.Controls.DataGridBoundColumn   Binding 6T   �� *
Nazwisko+ �� Mode$ TwoWay=�  5      $ 50Q�6%   $
 Imie��63   $ 90Q�6A    6O   �� *Imie+$ TwoWay=�  5      $ 35Q�6%   $ Numer Indeksu��63   $	 140Q�6J    6Y   �� *	NrIndeksu+$ TwoWay=�  5      $	 400Q�6%   $ Adres��64   $	 500Q�6C    6R   �� *Adres+$ TwoWay=�  5      $	 100Q�6%   $ Studia��64   $	 150Q�6D    6S   �� *Studia+$ TwoWay=�5      �� 5   
   -   5        $��Dodaj��5      $��Dodaj��6   $
��Left=�6.   $��488,391,0, 0q�6I   $	��Top=�6_   $��82��6w   $��37��6�   �� 5   
   -   5        $
��Usun��5      $��Usuń��6   $
��Left=�6,   $��627,391,0,0q�6G   $	��Top=�5      $��82��6)   $��37��6G   �� 5    
   -   5        $��myLabel��5       $��75,397,642.2,17.6q�6=   ��6   �� *	IdCounter+6=   �� 5!   
   $��
Wybrałeś��6   $
��Left=�6#   $��
10,397,0,0q�6>   $	��Top=�6R   $��31��6j   $��62��6v   �� 5#   
   $��
Studentów��6   $
��Left=�6$   $��110,397,0,0q�6?   $	��Top=�6T   $��31��6l   $��71��6x   �� 5$   
   
���   �$��1q�6%   $��39��69   $	��Top=�6E   $��
0,36,0.2,0q�6]   5%      5'      