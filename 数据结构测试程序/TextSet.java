package 数据结构;

import java.util.*;

public class TextSet {

	public static void main(String[] args) {
		
		//测试散列类HashSet规则集(用于存储无关顺序的元素)
		System.out.println("TextHashSet:　");
		Set<String> hashset = new HashSet<>();//创建一个散列类HashSet规则集
		
		//为散列集添加内容
		hashset.add("Beijing");
		hashset.add("Shanghai");
		hashset.add("Shenzhen");
		hashset.add("Xiamen");
		
		System.out.println(hashset);
		
		//使用for each循环来遍历规则集中的元素
		for (String s : hashset) {
			System.out.print(s.toUpperCase() + " ");
		}
		
		//使用foreach循环来遍历规则集中的元素
		System.out.println();
		hashset.forEach(e -> System.out.print(e.toLowerCase() + " "));
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//测试链式散列集LinkedHashSet（用于存储有关顺序的元素）
		System.out.println("TextLinkedHashSet: ");
		Set<String> linkedhashset=new LinkedHashSet<>();//创建一个链式散列集
		
		//为链式散列集添加内容
		linkedhashset.add("Beijing");
		linkedhashset.add("Shanghai");
		linkedhashset.add("Shenzhen");
		linkedhashset.add("Xiamen");
		
		System.out.println(linkedhashset);
		
		for (String l : linkedhashset) {
			System.out.print(l.toUpperCase() + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//测试树形集TreeSet（使存储的元素能够比较）
		System.out.println("TextTreeSet: ");
		TreeSet<String> treeset=new TreeSet<>(hashset);//创建一个树形集,并向其中添加内容
		
		System.out.println(treeset);
		
		for (String t : treeset) {
			System.out.print(t.toUpperCase() + " ");
		}
		
		System.out.println();
		//使用树形集函数来操作数据
		System.out.println("first(): " + treeset.first());//返回第一个元素
		System.out.println("last(): " + treeset.last());//返回最后一个元素
		System.out.println("headSet(\"Shenzhen\"): " + treeset.headSet("Shenzhen"));//返回之前的元素
		System.out.println("tailSet(\"Shenzhen\"): " + treeset.tailSet("Shenzhen"));//返回之后的元素，包括本身
		System.out.println("lower(\"X\"): " + treeset.lower("X"));//返回小于X的最大元素
		System.out.println("higher(\"X\"): " + treeset.higher("X"));//返回大于X的最小元素
		System.out.println("floor(\"X\"): " + treeset.floor("X"));//返回小于或等于X的最大元素
		System.out.println("ceiling(\"X\"): " + treeset.ceiling("X"));//返回大于或等于X的最小元素
		System.out.println("pollFirst(): " + treeset.pollFirst());//删除第一个元素并返回
		System.out.println("polllast(): " + treeset.pollLast());//删除最后一个元素并返回
		System.out.println("New treeset: " + treeset);//
	}

}
