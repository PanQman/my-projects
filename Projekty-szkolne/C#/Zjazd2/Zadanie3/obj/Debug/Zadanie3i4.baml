   M S B A M L   `   `   `  ����C  ?Zadanie3, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null#clr-namespace:Zadanie3Zadanie3  5   	       Zadanie3.Zadanie3i4   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   (localclr-namespace:Zadanie3     5   	     � Title$  
Zadanie3i4��5   	   $	��450��6   $	��800��6)    � WindowStartupLocation$ CenterScreen=�65    � 
ResizeMode$ NoResize=�6Z   .��5	      � .+�5
   
   &   System.Windows.Controls.DataGrid  -   5          Name$ StudentsGrid��5
      $��0,-6,-0.4,277q�6)      AutoGenerateColumns .     CanUserAddRows .     
IsReadOnly .    Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$
 Imie��6%   1  +System.Windows.Controls.DataGridBoundColumn	   Binding	 63   �� *Imie+  5      $ Nazwisko��6%   	 67   �� *
Nazwisko+  5      $ 
Nr indeksu��6%   	 69   �� *	Nrindeksu+5      �� 5   
   $��29,172,710.6,205q�6   .��6*   Imię60   �� 5   
   -   5        
 ��Name$
 nazwiskoBox��5   8   $��50��6   $��117,221,26.6,149q�6   68   �� 5   
   $��21,231,710.6,149q�6   .��6*   
Nazwisko64   �� 5   
   -   5        $
 	indeksBox��5   7   $��50��6   $��117,277,26.6,93q�6   67   �� 5   
   $��21,289,699.6,93q�6   .��6)   
Nr indeksu65   �� 5   
   -   5        $
 imieBox��5   8   $��50��6   $��117,165,26.6,205q�6   68   �� 5   
   -   5         ��Name$ Dodaj��5   t   $��Dodaj��6   $
��Left=�6!   $��117,362,0,0q�6<   $	��Top=�6Q   $��75��6i   6�   �� 5   
   -   5        $
 Usun��5   s   $��Usuń��6   $
��Left=�6    $��637,362,0,0q�6;   $	��Top=�6P   $��75��6h   6�   5      5      